package e.corp.sistema.emprestimo;


import e.corp.sistema.conta.Conta;
import e.corp.sistema.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import e.corp.sistema.exception.OperacaoInvalidaException;
import e.corp.sistema.transacao.TipoTransacao;

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;


@Setter
@Getter
@ToString
public class Financiamento {

    private String id;
    private Cliente cliente;
    private String objetoFinanciado;
    private double valorTotal;
    private double valorDivida;
    private double valorParcela;
    private int numeroParcelasTotais;
    private int numeroParcelasRestantes;

    public Financiamento(Cliente cliente, double valorTotal, int numeroParcelas, String objetoFinanciado){

        if(!validarFinanciamento(cliente.getRendaMensal(),valorTotal)){
            throw new OperacaoInvalidaException("Voce nao pode fazer um financiamento no nosso banco");
        }

        this.id = gerarNumero(4);
        this.cliente = cliente;
        this.numeroParcelasTotais = numeroParcelas;
        this.objetoFinanciado = objetoFinanciado;
        this.valorTotal = valorTotal;
        this.valorParcela = valorTotal / numeroParcelas;
        this.numeroParcelasRestantes = numeroParcelas;
        this.valorDivida = this.valorParcela * this.numeroParcelasRestantes;
    }

    public boolean validarFinanciamento(double rendaMensal, double valorFinanciamento){
        return ((rendaMensal*0.2)*72) > valorFinanciamento;
    }

    public void pagarParcelaFinanciamento(double valor, Conta conta){
        if(this.valorParcela > conta.getSaldo()){
            throw new OperacaoInvalidaException("Voce nao possui esse valor.");
        }else if(valor < 0){
            throw new OperacaoInvalidaException("Insira um valor positivo.");
        }else{

            conta.setExtrato(this.cliente,null, TipoTransacao.PARCELAFINANCIAMENTO, -valor);
            conta.setSaldo(-valor);
            this.numeroParcelasRestantes --;
            this.valorParcela = this.valorParcela * numeroParcelasRestantes * 1.05;

        }
    }

    public int vizualizarNumeroDeParcelas(){
        return this.numeroParcelasRestantes;
    }

    public double vizualizarDivida(){
        return this.valorDivida;
    }
}
