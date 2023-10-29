package e.corp.sistema.conta;


import e.corp.sistema.boleto.Boleto;
import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.exception.AutenticacaoException;
import e.corp.sistema.exception.OperacaoInvalidaException;
import e.corp.sistema.exception.ValidacaoException;
import e.corp.sistema.transacao.TipoTransacao;
import e.corp.sistema.transacao.Transacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarNumero;
import static e.corp.sistema.gerador.GeradorDeCaracteres.gerarSenha;

@Setter
@Getter
public class Conta {

    private Cliente cliente;
    private TipoConta tipoConta;
    private ArrayList<Transacao> extrato;
    private String senha;
    private String perguntaCor;
    private String perguntaComida;
    private String perguntaAnimal;
    private String numeroDaConta;
    private double limiteSaque;
    private double limitePix;
    private double limiteCreditoEspecial;
    private double saldo;

    public Conta(Cliente cliente, TipoConta tipoConta, String perguntasCor,
                 String perguntasComida, String perguntasAnimal) {

        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.perguntaCor = perguntasCor;
        this.perguntaAnimal = perguntasAnimal;
        this.perguntaComida = perguntasComida;
        this.limiteSaque = this.cliente.getRendaMensal() * 12;
        this.limitePix = this.cliente.getRendaMensal() * 12;
        this.limiteCreditoEspecial = this.cliente.getRendaMensal() * 1.5;
        this.numeroDaConta = gerarNumero(20);
        this.senha = gerarSenha(16);
        this.saldo = 0;
        extrato = new ArrayList<>();

    }

    public void realizarPix(double valor, Conta destino) {

        if (valor > this.saldo) {
            throw new OperacaoInvalidaException("Voce nao possui esse valor.");
        } else if (valor < 0) {
            throw new OperacaoInvalidaException("Voce nao pode enviar um valor negativo.");
        } else if (destino == null) {
            throw new OperacaoInvalidaException("Essa conta nao existe.");
        }


        this.extrato.add(new Transacao(this.cliente, destino.cliente, TipoTransacao.PIXENVIADO, valor));
        destino.extrato.add(new Transacao(this.cliente, destino.cliente, TipoTransacao.PIXRECEBIDO, valor));

        this.saldo -= valor;
        destino.setSaldo(destino.getSaldo() + valor);

    }

    public void realizarSaque(double valor) {

        if (valor > this.saldo) {
            throw new OperacaoInvalidaException("Voce nao possui esse valor.");
        } else if (valor < 0) {
            throw new OperacaoInvalidaException("Voce nao pode sacar um valor negativo.");
        }

        this.extrato.add(new Transacao(this.cliente, null, TipoTransacao.SAQUE, valor));
        this.saldo -= valor;
    }

    public void realizarDeposito(double valor) {

        if (valor < 0) {
            throw new OperacaoInvalidaException("Voce nao pode depositar um valor negativo.");
        } else {
            this.extrato.add(new Transacao(this.cliente, null, TipoTransacao.DEPOSITO, valor));
            this.saldo += valor;
        }
    }

    public void pagarBoleto(Boleto boleto) {
        if (boleto.getValor() > this.saldo) {
            throw new OperacaoInvalidaException("Voce nao possui saldo suficiente.");
        } else if (boleto.getVencimento().isBefore(LocalDate.now())) {
            throw new OperacaoInvalidaException("Esse boleto ja esta vencido.");
        } else if (boleto.isPago()) {
            throw new OperacaoInvalidaException("Esse boleto ja foi pago.");
        }
        this.extrato.add(new Transacao(this.cliente, null, TipoTransacao.BOLETO, boleto.getValor()));
        this.saldo -= boleto.getValor();
        boleto.setPago(true);
    }

    public void creditoEspecial() {

        if (!(this.saldo == 0)) {
            throw new OperacaoInvalidaException("Voce so pode usar o credito especial quando esta com exastos 0 R$.");
        }

        this.extrato.add(new Transacao(this.cliente, null, TipoTransacao.CREDITOESPECIAL, limiteCreditoEspecial));
        this.saldo -= limiteCreditoEspecial;
    }

    public List<Transacao> visualizarExtrato() {
        return this.extrato;
    }


    public void alterarSenha(String senhaAntiga, String senhaNova) {

        if (!this.senha.equals(senhaAntiga)) {
            throw new AutenticacaoException("Senha incorreta.");
        }

        this.senha = senhaNova;
    }

    public boolean perguntaSeguranca(String perguntaAnimal, String perguntaCor, String perguntaComida) {

        if (!(perguntaCor.equals(this.perguntaCor) && perguntaAnimal.equals(this.perguntaAnimal) && perguntaComida.equals(this.perguntaComida))) {
            throw new ValidacaoException("Alguma pergunta esta errada. Operacao negada.");
        } else {
            return true;
        }
    }

    public void setExtrato(Cliente clienteRemetente, Cliente clienteDestinatario, TipoTransacao tipoTransacao, double valor) {
        this.extrato.add(new Transacao(clienteRemetente, null, tipoTransacao, limiteCreditoEspecial));
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente = " + cliente +
                ", tipoConta = " + tipoConta +
                ", extrato = " + extrato +
                ", senha = '" + senha + '\'' +
                ", perguntaCor = '" + perguntaCor + '\'' +
                ", perguntaComida = '" + perguntaComida + '\'' +
                ", perguntaAnimal = '" + perguntaAnimal + '\'' +
                ", numeroDaConta = '" + numeroDaConta + '\'' +
                ", limiteSaque = " + limiteSaque +
                ", limitePix = " + limitePix +
                ", limiteCreditoEspecial = " + limiteCreditoEspecial +
                ", saldo = R$" + saldo +
                "}\n";
    }
}
