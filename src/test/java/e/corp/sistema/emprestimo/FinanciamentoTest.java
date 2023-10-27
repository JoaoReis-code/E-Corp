package e.corp.sistema.emprestimo;

import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.conta.TipoConta;
import e.corp.sistema.emprestimo.Financiamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static e.corp.sistema.emprestimo.Financiamento.validarFinanciamento;
import static org.junit.jupiter.api.Assertions.*;

class FinanciamentoTest {

    private Conta conta;
    private Cliente cliente;
    private Financiamento financiamento;

    @BeforeEach
    public void init(){
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

        cliente = new Cliente(nome, cpf, email, dataNascimento, sexo,rendaMensal);
        conta = new Conta(cliente,tipoConta,perguntaCor,perguntaComida,perguntaAnimal);
        conta.setSaldo(1000);

        financiamento = new Financiamento(conta, 1200,12, "carro");
    }

    @Test
    @DisplayName("Verifica se financiamento e valido")
    public void testfinanciamento01(){
        assertTrue(( validarFinanciamento(cliente.getRendaMensal(), 1000)));
    }

    @Test
    @DisplayName("Verifica se financiamento e valido")
    public void testfinanciamento02(){
        assertFalse(( validarFinanciamento(cliente.getRendaMensal(), 20000)));
    }

    @Test
    @DisplayName("Verifica se possui saldo ao pagar financiamento")
    public void testfinanciamento03(){

        String mensagem = "";

        conta.setSaldo(10);
        try{
            financiamento.pagarParcelaFinanciamento(conta);
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem,"Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Verifica se ja pagou todas as parcelas do financiamento")
    public void testfinanciamento04(){

        String mensagem = "";
        financiamento.setNumeroParcelasRestantes(0);
        try{
            financiamento.pagarParcelaFinanciamento(conta);
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem,"Voce ja pagou todo o seu financiamento.");
    }

    @Test
    @DisplayName("Verifica se devida e limpa depois que ja pagou todas as parcelas do financiamento")
    public void testfinanciamento05(){

        String mensagem = "";
        financiamento.setNumeroParcelasRestantes(0);
        try{
            financiamento.pagarParcelaFinanciamento(conta);
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }
        assertEquals(0, financiamento.getValorDivida());
    }
}