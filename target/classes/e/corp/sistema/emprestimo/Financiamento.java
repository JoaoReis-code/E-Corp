package e.corp.sistema.emprestimo;


import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.exception.OperacaoInvalidaException;
import e.corp.sistema.transacao.TipoTransacao;
import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD

import java.math.BigDecimal;
import java.math.RoundingMode;
=======
>>>>>>> d7cca2f838a493a8092535a46097eec0b5b4f41e

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;


@Setter
@Getter
public class Financiamento {

    private String id;
    private Cliente cliente;
    private String objetoFinanciado;
    private double valorTotal;
    private double valorDivida;
    private double valorParcela;
    private int numeroParcelasTotais;
    private int numeroParcelasRestantes;

    public Financiamento(Conta conta, double valorTotal, int numeroParcelas, String objetoFinanciado) {

        if (!validarFinanciamento(conta.getCliente().getRendaMensal(), valorTotal)) {
            throw new OperacaoInvalidaException("Voce nao pode fazer um financiamento no nosso banco");
        }

        this.id = gerarNumero(4);
        this.cliente = conta.getCliente();
        this.numeroParcelasTotais = numeroParcelas;
        this.objetoFinanciado = objetoFinanciado;
        this.valorTotal = valorTotal;
        this.valorParcela = valorTotal * calculaJuros(numeroParcelas) / numeroParcelas;
        this.numeroParcelasRestantes = numeroParcelas;
        this.valorDivida = this.valorParcela * this.numeroParcelasRestantes;
        conta.setExtrato(this.cliente, null, TipoTransacao.FINANCIAMENTO, this.valorParcela);
        conta.setSaldo(conta.getSaldo() + valorTotal);
    }

    public static boolean validarFinanciamento(double rendaMensal, double valorFinanciamento) {
        return ((rendaMensal * 0.2) * 72) > valorFinanciamento;
    }

<<<<<<< HEAD
    public static double calculaJuros(int numeroParcelas) {
        double valorJuros = (double) numeroParcelas / 100 + 1.1;
        return new BigDecimal(valorJuros).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

=======
>>>>>>> d7cca2f838a493a8092535a46097eec0b5b4f41e
    public void pagarParcelaFinanciamento(Conta conta) {
        if (this.valorParcela > conta.getSaldo()) {
            throw new OperacaoInvalidaException("Voce nao possui esse valor.");
        }

        if (numeroParcelasRestantes > 0) {
            conta.setExtrato(this.cliente, null, TipoTransacao.PARCELAFINANCIAMENTO, this.valorParcela);
            conta.setSaldo(conta.getSaldo() - this.valorParcela);
            this.numeroParcelasRestantes--;
            this.valorDivida = this.valorParcela * this.numeroParcelasRestantes;
        } else if (numeroParcelasRestantes == 0) {
            this.valorDivida = 0;
            throw new OperacaoInvalidaException("Voce ja pagou todo o seu financiamento.");
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
        return "Financiamento{" +
                "id = '" + id + '\'' +
                ", objetoFinanciado = '" + objetoFinanciado + '\'' +
                ", valorTotal = " + valorTotal +
                ", valorDivida = " + valorDivida +
                ", valorParcela = " + valorParcela +
                ", numeroParcelasTotais = " + numeroParcelasTotais +
                ", numeroParcelasRestantes = " + numeroParcelasRestantes +
                "}\n";
    }
}
