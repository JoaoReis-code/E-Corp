package e.corp.sistema.cartao;

import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.exception.AutenticacaoException;
import e.corp.sistema.exception.ValidacaoException;
import e.corp.sistema.transacao.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;

@Setter
@Getter
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

    public Cartao(Cliente cliente, TipoCartao tipoCartao) {

        this.nome = cliente.getNome();
        this.cpfCliente = cliente.getCpf();
        this.numero = gerarNumero(16);
        this.cvv = gerarNumero(3);
        this.vencimento = LocalDate.now().plusYears(5);
        this.limite = cliente.getRendaMensal() * 1.1;
        this.tipoCartao = tipoCartao;
        this.senha = gerarNumero(4);
        ;
    }

    public void debito(Conta conta, double valor, String senha) {
        if (TipoCartao.DEBITO == this.tipoCartao) {
            if (valor > 0) {
                if (senha.equals(this.senha)) {
                    if (this.limite >= valor) {
                        if (conta.getSaldo() > valor) {
                            this.limite -= valor;
                            conta.setSaldo(conta.getSaldo() - valor);
                            conta.setExtrato(conta.getCliente(), null, TipoTransacao.CARTAODEBITO, valor);
                        } else {
                            throw new ValidacaoException("Voce nao possui saldo suficientepra isso.");
                        }
                    } else {
                        throw new ValidacaoException("Voce nao possui limite pra isso.");
                    }
                } else {
                    throw new AutenticacaoException("A senha esta incorreta.");
                }
            } else {
                throw new AutenticacaoException("Voce so pode passar valores positivos no debito.");
            }
        } else {
            throw new ValidacaoException("Voce so pode usar cartoes de debito nessa funcao.");
        }
    }

    public void credito(double valor, String senha, int numeroParcelas) {
        if (TipoCartao.CREDITO == this.tipoCartao) {
            if (valor > 0) {
                if (senha.equals(this.senha)) {
                    if (this.limite >= valor) {
                        this.numeroParcelasTotais = numeroParcelas;
                        this.numeroParcelasRestantes = numeroParcelas;
                        this.valorParcela = valor / numeroParcelas;
                        this.limite -= valor;
                        this.valorDivida += valor;
                    } else {
                        throw new ValidacaoException("Voce nao possui limite pra isso.");
                    }
                } else {
                    throw new AutenticacaoException("A senha esta incorreta.");
                }
            } else {
                throw new ValidacaoException("Voce so pode passar valores positivos no credito.");
            }
        } else {
            throw new ValidacaoException("Voce so pode usar cartoes de credito nessa funcao.");
        }
    }

    public void pagarParcela(Conta conta) {
        if (TipoCartao.CREDITO == this.tipoCartao) {
            if (conta.getSaldo() >= this.valorParcela) {
                if (this.numeroParcelasRestantes > 0) {
                    conta.setSaldo(conta.getSaldo() - this.valorParcela);
                    conta.setExtrato(conta.getCliente(), null, TipoTransacao.CARTAOCREDITO, this.valorParcela);
                    this.numeroParcelasRestantes--;
                    this.valorDivida = this.valorParcela * numeroParcelasRestantes;
                } else if (this.numeroParcelasRestantes == 0) {
                    this.limite = conta.getCliente().getRendaMensal() * 1.1;
                    throw new ValidacaoException("Voce nao possui parcelas a pagar.");
                }
            } else {
                throw new ValidacaoException("Voce nao possui dinheiro suficiente para pagar essa divida.");
            }
        } else {
            throw new ValidacaoException("Voce so pode usar cartoes de credito nessa funcao.");
        }
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "nome='" + nome + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                ", numero='" + numero + '\'' +
                ", vencimento=" + vencimento +
                ", cvv='" + cvv + '\'' +
                ", limite=" + limite +
                ", senha='" + senha + '\'' +
                ", tipoCartao=" + tipoCartao +
                ", valorDivida=" + valorDivida +
                ", valorParcela=" + valorParcela +
                ", numeroParcelasTotais=" + numeroParcelasTotais +
                ", numeroParcelasRestantes=" + numeroParcelasRestantes +
                "}\n";
    }
}
