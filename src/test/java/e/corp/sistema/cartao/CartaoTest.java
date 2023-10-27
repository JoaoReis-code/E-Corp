package e.corp.sistema.cartao;

import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.conta.TipoConta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static e.corp.sistema.cliente.Cliente.validarIdade;
import static org.junit.jupiter.api.Assertions.*;

class CartaoTest {

    private Conta conta;
    private Cliente cliente;
    private Cartao cartaoCredito;
    private Cartao cartaoDebito;

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

        cartaoCredito = new Cartao(cliente, TipoCartao.CREDITO);
        cartaoDebito = new Cartao(cliente, TipoCartao.DEBITO);
    }

    @Test
    @DisplayName("Valida saldo da conta e limite apos debito bem sucedido")
    public void testCartaoDebito01(){
        double limiteEsperado = 1000;
        double saldoEsperado = 900;

        cartaoDebito.debito(conta,100,cartaoDebito.getSenha());

        assertTrue((conta.getSaldo() == saldoEsperado) && (cartaoDebito.getLimite() == limiteEsperado));
    }

    @Test
    @DisplayName("Valida senha do cartao")
    public void testCartaoDebito02(){
        String mensagem = "";

        cartaoDebito.setSenha("0000");
        try{
            cartaoDebito.debito(conta,100,"1234");
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }

        assertEquals("A senha esta incorreta.", mensagem);
    }

    @Test
    @DisplayName("Valida limite do cartao")
    public void testCartaoDebito03(){
        String mensagem = "";

        try{
            cartaoDebito.debito(conta,conta.getCliente().getRendaMensal() * 1.2,cartaoDebito.getSenha());
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }

        assertEquals("Voce nao possui limite pra isso.", mensagem);
    }

    @Test
    @DisplayName("Valida tipo do cartao de debito")
    public void testCartaoDebito04(){
        String mensagem = "";

        try{
            cartaoCredito.debito(conta,conta.getCliente().getRendaMensal() * 1,cartaoDebito.getSenha());
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }

        assertEquals("Voce so pode usar cartoes de debito nessa funcao.", mensagem);
    }

    @Test
    @DisplayName("Valida saldo insuficiente")
    public void testCartaoDebito05(){
        String mensagem = "";

        conta.setSaldo(10);

        try{
            cartaoDebito.debito(conta,50,cartaoDebito.getSenha());
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }

        assertEquals("Voce nao possui saldo suficientepra isso.", mensagem);
    }

    @Test
    @DisplayName("Valida valor negativo")
    public void testCartaoDebito06(){
        String mensagem = "";

        try{
            cartaoDebito.debito(conta,conta.getCliente().getRendaMensal() * -1,cartaoDebito.getSenha());
        }catch (Exception ex){
            mensagem = ex.getMessage();
        }

        assertEquals("Voce so pode passar valores positivos no debito.", mensagem);
    }


    @Test
    @DisplayName("Valida limite restante do cartao de credito")
    public void testCartaoCredito01(){
        double valor = 100;
        cartaoCredito.credito(conta,valor,cartaoCredito.getSenha(), 2);


        assertEquals(cartaoCredito.getLimite(), (conta.getCliente().getRendaMensal() * 1.1) - valor);
    }

    @Test
    @DisplayName("Valida valor da divida do cartao de credito")
    public void testCartaoCredito02(){
        double valor = 100;
        cartaoCredito.credito(conta,valor,cartaoCredito.getSenha(), 2);


        assertEquals(cartaoCredito.getValorDivida(), valor);
    }

    @Test
    @DisplayName("Valida o numero de parcelas do cartao de credito")
    public void testCartaoCredito03(){
        int parcelas = 4;
        cartaoCredito.credito(conta,conta.getCliente().getRendaMensal() * 1,cartaoCredito.getSenha(), parcelas);


        assertEquals(cartaoCredito.getNumeroParcelasTotais(), parcelas);
    }

    @Test
    @DisplayName("Valida limite disponivel")
    public void testCartaoCredito04(){
        String message = "";


        try{
            cartaoCredito.credito(conta,conta.getCliente().getRendaMensal() * 2,cartaoCredito.getSenha(), 2);
        }catch (Exception ex){
            message = ex.getMessage();
        }
        assertEquals(message, "Voce nao possui limite pra isso.");
    }

    @Test
    @DisplayName("Valida senha")
    public void testCartaoCredito05(){
        String message = "";

        cartaoCredito.setSenha("0000");
        try{
            cartaoCredito.credito(conta,conta.getCliente().getRendaMensal() * 1,"1234", 2);
        }catch (Exception ex){
            message = ex.getMessage();
        }
        assertEquals(message, "A senha esta incorreta.");
    }

    @Test
    @DisplayName("Valida valor positivo")
    public void testCartaoCredito06(){
        String message = "";

        try{
            cartaoCredito.credito(conta,conta.getCliente().getRendaMensal() * -1,"1234", 2);
        }catch (Exception ex){
            message = ex.getMessage();
        }
        assertEquals(message, "Voce so pode passar valores positivos no credito.");
    }

    @Test
    @DisplayName("Valida tipo do cartao de credito")
    public void testCartaoCredito07(){
        String message = "";

        try{
            cartaoDebito.credito(conta,conta.getCliente().getRendaMensal() * 1,"1234", 2);
        }catch (Exception ex){
            message = ex.getMessage();
        }
        assertEquals(message, "Voce so pode usar cartoes de credito nessa funcao.");
    }

    @Test
    @DisplayName("Valida pagamento da parcela do cartao de credito")
    public void testCartaoCredito08(){
        String message = "";

        try {
            conta.setSaldo(500);
            cartaoCredito.credito(conta,1000, cartaoCredito.getSenha(), 2);
            cartaoDebito.pagarParcela(conta);
        }catch (Exception ex){
            message = ex.getMessage();
        }

        assertEquals(message,"Voce so pode usar cartoes de credito nessa funcao.");
    }

    @Test
    @DisplayName("Valida numero de parcelas restantes do cartao de credito")
    public void testCartaoCredito09(){

        conta.setSaldo(500);
        cartaoCredito.credito(conta,1000, cartaoCredito.getSenha(), 2);
        cartaoCredito.pagarParcela(conta);

        assertEquals(1,cartaoCredito.getNumeroParcelasRestantes());
    }

    @Test
    @DisplayName("Valida numero de parcelas totais do cartao de credito")
    public void testCartaoCredito10(){

        cartaoCredito.credito(conta,1000, cartaoCredito.getSenha(), 10);

        assertEquals(10,cartaoCredito.getNumeroParcelasTotais());
    }

    @Test
    @DisplayName("Valida se limite volta apos pagar divida")
    public void testCartaoCredito11(){

        String message = "";
        conta.setSaldo(5000);

        try{
            cartaoCredito.credito(conta,500, cartaoCredito.getSenha(), 1);
            cartaoCredito.pagarParcela(conta);
            cartaoCredito.pagarParcela(conta);
        }catch (Exception ex){
            message = ex.getMessage();
        }

        assertEquals(message,"Voce nao possui parcelas a pagar.");
    }

    @Test
    @DisplayName("Valida se ainda possui divida")
    public void testCartaoCredito12(){
        String message = "";

        try{
            conta.setSaldo(5000);
            cartaoCredito.credito(conta,500, cartaoCredito.getSenha(), 2);
            cartaoCredito.pagarParcela(conta);
            cartaoCredito.pagarParcela(conta);
            cartaoCredito.pagarParcela(conta);
        }catch(Exception ex){
            message = ex.getMessage();
        }

        assertEquals(message,"Voce nao possui parcelas a pagar.");
    }

    @Test
    @DisplayName("Valida se possui dinheiro suficiente")
    public void testCartaoCredito13(){
        String message = "";

        try{
            conta.setSaldo(50);
            cartaoCredito.credito(conta,500, cartaoCredito.getSenha(), 2);
            cartaoCredito.pagarParcela(conta);
        }catch(Exception ex){
            message = ex.getMessage();
        }

        assertEquals(message,"Voce nao possui dinheiro suficiente para pagar essa divida.");
    }
}