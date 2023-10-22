package e.corp.sistema.emprestimo;


import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.transacao.TipoTransacao;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import e.corp.sistema.exception.OperacaoInvalidaException;

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;

@Setter
@Getter
@ToString
public class Emprestimo {

    private String id;
    private Cliente cliente;
    private double valorTotal;
    private double valorDivida;
    private double valorParcela;
    private int numeroParcelasTotais;
    private int numeroParcelasRestantes;

    public Emprestimo(Cliente cliente, double valorTotal, int numeroParcelas){

        if(!validarEmprestimo(cliente.getRendaMensal(),valorTotal)){
            throw new OperacaoInvalidaException("Voce nao pode fazer um emprestimo no nosso banco");
        }

        this.id = gerarNumero(4);
        this.cliente = cliente;
        this.numeroParcelasTotais = numeroParcelas;
        this.valorTotal = valorTotal;
        this.valorParcela = valorTotal / numeroParcelas;
        this.numeroParcelasRestantes = numeroParcelas;
        this.valorDivida = this.valorParcela * this.numeroParcelasRestantes;
    }

    public boolean validarEmprestimo(double rendaMensal, double valorEmprestimo){
        return ((rendaMensal*0.3)*24) > valorEmprestimo;
    }

    public void pagarParcelaEmprestimo(double valor, Conta conta){
        if(this.valorParcela > conta.getSaldo()){
            throw new OperacaoInvalidaException("Voce nao possui esse valor.");
        }else if(valor < 0){
            throw new OperacaoInvalidaException("Insira um valor positivo.");
        }else{

            conta.setExtrato(this.cliente,null, TipoTransacao.PARCELAEMPRESTIMO, -valor);
            conta.setSaldo(-valor);
            this.numeroParcelasRestantes --;
        }
    }

    public int vizualizarNumeroDeParcelas(){
        return this.numeroParcelasRestantes;
    }

    public double vizualizarDivida(){
        return this.valorDivida;
    }
}
