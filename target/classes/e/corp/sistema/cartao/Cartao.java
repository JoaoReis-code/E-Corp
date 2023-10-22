package e.corp.sistema.cartao;

import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.exception.AutenticacaoException;
import e.corp.sistema.transacao.TipoTransacao;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import e.corp.sistema.exception.ValidacaoException;

import java.time.LocalDate;

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;

@Setter
@Getter
@ToString
public class Cartao {

    private String nome;
    private String cpfCliente;
    private String numero;
    private LocalDate vencimento;
    private String cvv;
    private double limite;
    private String senha;
    private TipoCartao tipoCartao;
    private double valorDivida;
    private double valorParcela;
    private int numeroParcelasTotais;
    private int numeroParcelasRestantes;

    public Cartao(Cliente cliente, String senha, TipoCartao tipoCartao) {
        if (senha.length() > 4) {
            throw new ValidacaoException("O numero maximo de caracteres e 4");
        }

        this.nome = cliente.getNome();
        this.cpfCliente = cliente.getCpf();
        this.numero = gerarNumero(16);
        this.cvv = gerarNumero(3);
        this.vencimento = LocalDate.now().plusYears(5);
        this.limite = cliente.getRendaMensal() * 1.1;
        this.tipoCartao = tipoCartao;
        this.senha = senha;
    }

    public void debito(Conta conta, double valor, String senha) {
        if (TipoCartao.DEBITO == this.tipoCartao) {
            if (senha.equals(this.senha)) {
                if (this.limite >= valor) {
                    this.limite -= valor;
                    conta.setSaldo(conta.getSaldo() - valor);
                    conta.setExtrato(conta.getCliente(), null, TipoTransacao.CARTAODEBITO, valor);
                } else {
                    throw new ValidacaoException("Voce nao possui limite pra isso");
                }
            } else {
                throw new AutenticacaoException("A senha esta incorreta");
            }
        } else {
            throw new ValidacaoException("Voce so pode usar cartoes de debito nessa funcao");
        }
    }

    public void credito(Conta conta, double valor, String senha, int numeroParcelas) {
        if (TipoCartao.CREDITO == this.tipoCartao) {
            if (senha.equals(this.senha)) {
                if (this.limite >= valor) {
                    this.numeroParcelasTotais = numeroParcelas;
                    this.numeroParcelasRestantes = numeroParcelas;
                    this.valorParcela = valor/numeroParcelas;
                    this.limite -= valor;
                    this.valorDivida += valor;
                } else {
                    throw new ValidacaoException("Voce nao possui limite pra isso");
                }
            } else {
                throw new AutenticacaoException("A senha esta incorreta");
            }
        } else {
            throw new ValidacaoException("Voce so pode usar cartoes de credito nessa funcao");
        }
    }

    public void pagarParcela(Conta conta){
        if(conta.getSaldo()> this.valorParcela){
            if(this.numeroParcelasRestantes > 0){

                this.valorDivida -= this.valorParcela;
                this.numeroParcelasRestantes--;
                conta.setSaldo(conta.getSaldo() - this.valorParcela);
                conta.setExtrato(conta.getCliente(), null, TipoTransacao.CARTAOCREDITO, this.valorParcela);
            }else if(this.numeroParcelasRestantes == 0 && this.valorDivida == 0){
                this.limite = conta.getCliente().getRendaMensal() * 1.1;;
            }else{
                throw new ValidacaoException("Voce nao possui parcelas a pagar");
            }
        }else{
            throw new ValidacaoException("Voce nao possui dinheiro suficiente para pagar essa divida");
        }

    }

}
