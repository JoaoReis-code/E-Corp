package e.corp.sistema.crud;

import e.corp.sistema.boleto.Boleto;
import e.corp.sistema.cartao.Cartao;
import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.emprestimo.Emprestimo;
import e.corp.sistema.emprestimo.Financiamento;
import e.corp.sistema.exception.ValidacaoException;

import java.util.LinkedList;
import java.util.List;

public class Crud {

    private static final List<Conta> contas = new LinkedList<>();
    private static final List<Cliente> clientes = new LinkedList<>();
    private static final List<Emprestimo> emprestimos = new LinkedList<>();
    private static final List<Financiamento> financiamentos = new LinkedList<>();
    private static final List<Boleto> boletos = new LinkedList<>();

    private static final List<Cartao> cartoes = new LinkedList<>();

    public static void add(Conta conta) {
        contas.add(conta);
    }

    public static Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroDaConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public static void excluirConta(Conta conta) {
        if (conta.getSaldo() >= 0) {
            contas.remove(conta);
        } else {
            throw new ValidacaoException("Voce so pode excluir sua conta se nao estiver devendo o banco");
        }
    }

    public static List<Conta> contas() {
        return contas;
    }

    public static void add(Cliente cliente) {
        clientes.add(cliente);
    }


    public static void add(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }


    public static Emprestimo buscarEmprestimo(String id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId().equals(id)) {
                return emprestimo;
            }
        }
        return null;
    }

    public static List<Emprestimo> matchEmprestimo(Cliente cliente) {
        List<Emprestimo> emprestimosCliente = new LinkedList<>();

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().equals(cliente)) {
                emprestimosCliente.add(emprestimo);
            }
        }
        return emprestimosCliente;
    }

    public static void add(Financiamento financiamento) {
        financiamentos.add(financiamento);
    }


    public static Financiamento buscarFinanciamento(String id) {
        for (Financiamento financiamento : financiamentos) {
            if (financiamento.getId().equals(id)) {
                return financiamento;
            }
        }
        return null;
    }

    public static List<Financiamento> matchFinanciamento(Cliente cliente) {
        List<Financiamento> financiamentosCliente = new LinkedList<>();
        for (Financiamento financiamento : financiamentos) {
            if (financiamento.getCliente().equals(cliente)) {
                financiamentosCliente.add(financiamento);
            }
        }
        return financiamentosCliente;
    }


    public static void add(Boleto boleto) {
        boletos.add(boleto);
    }

    public static void remove(Boleto boleto) {
        boletos.remove(boleto);
    }

    public static List<Boleto> boletos() {
        return boletos;
    }

    public static Boleto buscarBoleto(String id) {
        for (Boleto boleto : boletos) {
            if (boleto.getCodigo().equals(id)) {
                return boleto;
            }
        }
        return null;
    }


    public static void add(Cartao cartao) {
        cartoes.add(cartao);
    }

    public static void remove(Cartao cartao) {
        cartoes.remove(cartao);
    }

    public static List<Cartao> cartoes() {
        return cartoes;
    }


    public static Cartao buscarCartao(String numeroCartao) {
        for (Cartao cartoes : cartoes) {
            if (cartoes.getNumero().equals(numeroCartao)) {
                return cartoes;
            }
        }
        return null;
    }

    public static List<Cartao> matchCartoes(Cliente cliente) {
        List<Cartao> cartoesCliente = new LinkedList<>();
        for (Cartao cartao : cartoes) {
            if (cartao.getCpfCliente().equals(cliente.getCpf())) {
                cartoesCliente.add(cartao);
            }
        }
        return cartoesCliente;
    }
}

