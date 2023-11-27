package e.corp.sistema.emprestimo;


import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.exception.OperacaoInvalidaException;
import e.corp.sistema.transacao.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;

@Setter
@Getter
public class Emprestimo {

    private String id;
    private Cliente cliente;
    private double valorTotal;
    private double valorDivida;
    private double valorParcela;
    private int numeroParcelasTotais;
    private int numeroParcelasRestantes;

    public Emprestimo(Conta conta, double valorTotal, int numeroParcelas) {

        if (!validarEmprestimo(conta.getCliente().getRendaMensal(), valorTotal)) {
            throw new OperacaoInvalidaException("Voce nao pode fazer um emprestimo no nosso banco");
        }

        this.id = gerarNumero(4);
        this.cliente = conta.getCliente();
        this.numeroParcelasTotais = numeroParcelas;
        this.valorTotal = valorTotal;
        this.valorParcela = valorTotal * calculaJuros(numeroParcelas) / numeroParcelas;
        this.numeroParcelasRestantes = numeroParcelas;
        this.valorDivida = this.valorParcela * this.numeroParcelasRestantes;
        conta.setExtrato(this.cliente, null, TipoTransacao.EMPRESTIMO, this.valorParcela);
        conta.setSaldo(conta.getSaldo() + valorTotal);
    }

    public static boolean validarEmprestimo(double rendaMensal,
                                            double valorEmprestimo) {
        return ((rendaMensal * 0.3) * 24) > valorEmprestimo;
    }

    public static double calculaJuros(int numeroParcelas) {
        double valorJuros = (double) numeroParcelas / 100 + 1;
        return new BigDecimal(valorJuros).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void pagarParcelaEmprestimo(Conta conta) {
        if (this.valorParcela > conta.getSaldo()) {
            throw new OperacaoInvalidaException("Voce nao possui esse valor.");
        }
        if (numeroParcelasRestantes > 0) {
            conta.setExtrato(this.cliente, null, TipoTransacao.PARCELAEMPRESTIMO, this.valorParcela);
            conta.setSaldo(conta.getSaldo() - this.valorParcela);
            this.numeroParcelasRestantes--;
            this.valorDivida = this.valorParcela * this.numeroParcelasRestantes;
        } else if (numeroParcelasRestantes == 0) {
            this.valorDivida = 0;
            throw new OperacaoInvalidaException("Voce ja pagou todo o seu emprestimo.");
        }
    }

    public int vizualizarNumeroDeParcelas() {
        return this.numeroParcelasRestantes;
    }

    public double vizualizarDivida() {
        return this.valorDivida;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id = '" + id + '\'' +
                ", valorTotal = " + valorTotal +
                ", valorDivida = " + valorDivida +
                ", valorParcela = " + valorParcela +
                ", numeroParcelasTotais = " + numeroParcelasTotais +
                ", numeroParcelasRestantes = " + numeroParcelasRestantes +
                "}\n";
    }
}
