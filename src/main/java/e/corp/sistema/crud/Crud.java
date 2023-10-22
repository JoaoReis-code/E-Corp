package e.corp.sistema.crud;

import e.corp.sistema.boleto.Boleto;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.emprestimo.Emprestimo;
import e.corp.sistema.emprestimo.Financiamento;
import e.corp.sistema.cartao.Cartao;

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

    public static void remove(Conta conta) {
        contas.remove(conta);
    }

    public static List<Conta> contas() {
        return contas;
    }


    public static Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroDaConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public static Conta buscarConta(Cliente cliente) {
        for (Conta conta : contas) {
            if (conta.getCliente().equals(cliente)) {
                return conta;
            }
        }
        return null;
    }

    public static void add(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void remove(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static List<Cliente> clientes() {
        return clientes;
    }

    public static Cliente buscarCliente(String numeroConta) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(numeroConta)) {
                return cliente;
            }
        }
        return null;
    }

    public static void add(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public static void remove(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
    }

    public static List<Emprestimo> emprestimos() {
        return emprestimos;
    }

    public static Emprestimo buscarEmprestimo(String id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId().equals(id)) {
                return emprestimo;
            }
        }
        return null;
    }

    public static Emprestimo matchEmprestimo(Cliente cliente) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().equals(cliente)) {
                return emprestimo;
            }
        }
        return null;
    }

    public static void add(Financiamento financiamento) {
        financiamentos.add(financiamento);
    }
    public static void remove(Financiamento financiamento) {
        financiamentos.remove(financiamento);
    }

    public static List<Financiamento> financiamentos() {
        return financiamentos;
    }

    public static Financiamento buscarFinanciamento(String id) {
        for (Financiamento financiamento : financiamentos) {
            if (financiamento.getId().equals(id)) {
                return financiamento;
            }
        }
        return null;
    }

    public static Financiamento matchFinanciamento(Cliente cliente) {
        for (Financiamento financiamento : financiamentos) {
            if (financiamento.getCliente().equals(cliente)) {
                return financiamento;
            }
        }
        return null;
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

    public static Cartao matchCartoes(Cliente cliente) {
        for (Cartao cartao : cartoes) {
            if (cartao.getCpfCliente().equals(cliente.getCpf())) {
                return cartao;
            }
        }
        return null;
    }
}

