package e.corp.sistema.emprestimo;

import e.corp.sistema.cartao.Cartao;
import e.corp.sistema.cartao.TipoCartao;
import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.conta.TipoConta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static e.corp.sistema.emprestimo.Emprestimo.validarEmprestimo;
import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    private Conta conta;
    private Cliente cliente;
    private Emprestimo emprestimo;

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

        emprestimo = new Emprestimo(conta, 1200,12);
    }

    @Test
    @DisplayName("Verifica se emprestimo e valido")
    public void testEmprestimo01(){
        assertTrue(( validarEmprestimo(cliente.getRendaMensal(), 1000)));
    }

    @Test
    @DisplayName("Verifica se emprestimo e valido")
    public void testEmprestimo02(){
        assertFalse(( validarEmprestimo(cliente.getRendaMensal(), 20000)));
    }

    @Test
    @DisplayName("Verifica se possui saldo ao pagar emprestimo")
    public void testEmprestimo03(){

        String mensagem = "";

        conta.setSaldo(10);
        try{
            emprestimo.pagarParcelaEmprestimo(conta);
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem,"Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Verifica se ja pagou todas as parcelas do emprestimo")
    public void testEmprestimo04(){

        String mensagem = "";
        emprestimo.setNumeroParcelasRestantes(0);
        try{
            emprestimo.pagarParcelaEmprestimo(conta);
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem,"Voce ja pagou todo o seu emprestimo.");
    }

    @Test
    @DisplayName("Verifica se devida e limpa depois que ja pagou todas as parcelas do emprestimo")
    public void testEmprestimo05(){

        String mensagem = "";
        emprestimo.setNumeroParcelasRestantes(0);
        try{
            emprestimo.pagarParcelaEmprestimo(conta);
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }
        assertEquals(0, emprestimo.getValorDivida());
    }
}