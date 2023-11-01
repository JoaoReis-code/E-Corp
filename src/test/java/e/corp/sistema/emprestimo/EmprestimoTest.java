package e.corp.sistema.emprestimo;

import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.conta.TipoConta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static e.corp.sistema.emprestimo.Emprestimo.calculaJuros;
import static e.corp.sistema.emprestimo.Emprestimo.validarEmprestimo;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    private Conta conta;
    private Cliente cliente;
    private Emprestimo emprestimo;

    @BeforeEach
    public void init() {
        String nome = "Joao";
        String cpf = "11122233344";
        String email = "dgbdb@dfdfd";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.MASCULINO;
        double rendaMensal = 1000;

        TipoConta tipoConta = TipoConta.CORRENTE;
        String perguntaCor = "preto";
        String perguntaComida = "macarrao";
        String perguntaAnimal = "cachorro";

        cliente = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        conta = new Conta(cliente, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);
        conta.setSaldo(1000);

        emprestimo = new Emprestimo(conta, 1200, 12);
    }

    @Test
    @DisplayName("Verifica se emprestimo e valido")
    public void testEmprestimo01() {
        assertTrue((validarEmprestimo(cliente.getRendaMensal(), 1000)));
    }

    @Test
    @DisplayName("Verifica se emprestimo e valido")
    public void testEmprestimo02() {
        assertFalse((validarEmprestimo(cliente.getRendaMensal(), 20000)));
    }

    @Test
    @DisplayName("Verifica se possui saldo ao pagar emprestimo")
    public void testEmprestimo03() {

        String mensagem = "";

        conta.setSaldo(10);
        try {
            emprestimo.pagarParcelaEmprestimo(conta);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Verifica se ja pagou todas as parcelas do emprestimo")
    public void testEmprestimo04() {

        String mensagem = "";
        emprestimo.setNumeroParcelasRestantes(0);
        try {
            emprestimo.pagarParcelaEmprestimo(conta);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce ja pagou todo o seu emprestimo.");
    }

    @Test
    @DisplayName("Verifica se divida e limpa depois que ja pagou todas as parcelas do emprestimo")
    public void testEmprestimo05() {

        String mensagem = "";
        emprestimo.setNumeroParcelasRestantes(0);
        try {
            emprestimo.pagarParcelaEmprestimo(conta);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(0, emprestimo.getValorDivida());
    }

    @Test
    @DisplayName("Emprestimo valido")
    public void testEmprestimo06() {
        assertTrue((validarEmprestimo(cliente.getRendaMensal(), 670)));
    }

    @Test
    @DisplayName("Verifica se emprestimo e valido")
    public void testEmprestimo07() {
        assertFalse((validarEmprestimo(cliente.getRendaMensal(), 97000000)));
    }

    @Test
    @DisplayName("Verifica saldo ao pagar emprestimo")
    public void testEmprestimo08() {

        String mensagem = "";

        conta.setSaldo(-10);
        try {
            emprestimo.pagarParcelaEmprestimo(conta);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Verifica se saldo igual a zero ao pagar emprestimo")
    public void testEmprestimo09() {

        String mensagem = "";

        conta.setSaldo(0);
        try {
            emprestimo.pagarParcelaEmprestimo(conta);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Verifica se parcelas estao pagas")
    public void testEmprestimo10() {

        String mensagem = "";
        emprestimo.setNumeroParcelasRestantes(1);
        conta.setSaldo(99999);
        try {
            emprestimo.pagarParcelaEmprestimo(conta);
            emprestimo.pagarParcelaEmprestimo(conta);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce ja pagou todo o seu emprestimo.");
    }

    @Test
    @DisplayName("Calcula juros")
    public void testEmprestimo11(){
        double valorEsperado = 1.10;

        assertEquals(calculaJuros(10), valorEsperado);
    }

    @Test
    @DisplayName("Calcula juros")
    public void testEmprestimo12(){
        double valorEsperado = 1.25;

        assertEquals(calculaJuros(25), valorEsperado);
    }
    @Test
    @DisplayName("Calcula juros")
    public void testEmprestimo13(){
        double valorEsperado = 2;

        assertEquals(calculaJuros(100), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo14(){
        double valorEsperado = 1.12;

        assertEquals(calculaJuros(12), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo15(){
        double valorEsperado = 1.01;

        assertEquals(calculaJuros(1), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo16(){
        double valorEsperado = 1.3;

        assertEquals(calculaJuros(30), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo17(){
        double valorEsperado = 11;

        assertEquals(calculaJuros(1000), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo18(){
        double valorEsperado = 1.8;

        assertEquals(calculaJuros(80), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo19(){
        double valorEsperado = 1.47;

        assertEquals(calculaJuros(47), valorEsperado);
    }@Test
    @DisplayName("Calcula juros")
    public void testEmprestimo20() {
        double valorEsperado = 69.69;

        assertEquals(calculaJuros(6869), valorEsperado);
    }
}