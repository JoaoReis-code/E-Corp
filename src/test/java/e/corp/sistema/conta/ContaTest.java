package e.corp.sistema.conta;

import e.corp.sistema.boleto.Boleto;
import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.crud.Crud;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaTest {

    private Conta conta;
    private Cliente cliente;

    @BeforeEach
    public void init() {
        String nome = "Joao";
        String cpf = "11122233344";
        String email = "dgbdb@dfdfd";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.MASCULINO;
        double rendaMensal = 2544;

        TipoConta tipoConta = TipoConta.CORRENTE;
        String perguntaCor = "preto";
        String perguntaComida = "macarrao";
        String perguntaAnimal = "cachorro";

        cliente = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        conta = new Conta(cliente, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);
    }

    @Test
    @DisplayName("Realiza Pix possuindo saldo")
    public void testPix01() {
        String nome = "xxnh";
        String cpf = "12345678910";
        String email = "dgbdb@dfdfd";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.MASCULINO;
        double rendaMensal = 200;

        TipoConta tipoConta = TipoConta.CORRENTE;
        String perguntaCor = "preto";
        String perguntaComida = "comida";
        String perguntaAnimal = "animal";

        Cliente cliente2 = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        Conta conta2 = new Conta(cliente, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);
        Crud.add(conta2);

        conta.setSaldo(100);
        conta.realizarPix(100, conta2);
        assertEquals(0, conta.getSaldo());
    }

    @Test
    @DisplayName("Impede Pix sem saldo")
    public void testPix02() {
        String nome = "xxnh";
        String cpf = "12345678910";
        String email = "dgbdb@dfdfd";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.MASCULINO;
        double rendaMensal = 200;

        TipoConta tipoConta = TipoConta.CORRENTE;
        String perguntaCor = "preto";
        String perguntaComida = "comida";
        String perguntaAnimal = "animal";

        Cliente cliente2 = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        Conta conta2 = new Conta(cliente, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);

        String mensagem = "";

        try {
            conta.setSaldo(100);
            conta.realizarPix(1000, conta2);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Impede Pix negativo")
    public void testPix03() {
        String nome = "xxnh";
        String cpf = "12345678910";
        String email = "dgbdb@dfdfd";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.MASCULINO;
        double rendaMensal = 200;

        TipoConta tipoConta = TipoConta.CORRENTE;
        String perguntaCor = "preto";
        String perguntaComida = "comida";
        String perguntaAnimal = "animal";

        Cliente cliente2 = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        Conta conta2 = new Conta(cliente, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);

        String mensagem = "";

        try {
            conta.setSaldo(100);
            conta.realizarPix(-1000, conta2);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce nao pode enviar um valor negativo.");
    }

    @Test
    @DisplayName("Impede Pix para conta que nao existe")
    public void testPix04() {

        String mensagem = "";

        conta.setSaldo(100);
        try {
            conta.realizarPix(10, null);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Essa conta nao existe.");
    }

    @Test
    @DisplayName("Realiza saque pois possui saldo")
    public void testSaque01() {
        double valorEsperado = 1000;

        conta.setSaldo(2000);
        conta.realizarSaque(1000);
        assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("Impede saque valor negativo")
    public void testSaque02() {
        String mensagem = "";

        try {
            conta.realizarSaque(-1000);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce nao pode sacar um valor negativo.");
    }

    @Test
    @DisplayName("Impede saque sem saldo")
    public void testSaque03() {
        String mensagem = "";

        try {
            conta.realizarSaque(1000);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce nao possui esse valor.");
    }

    @Test
    @DisplayName("Impede deposito negativo")
    public void testDeposito01() {
        String mensagem = "";

        try {
            conta.realizarDeposito(-1);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals(mensagem, "Voce nao pode depositar um valor negativo.");
    }

    @Test
    @DisplayName("Realiza deposito coreetamente")
    public void testDeposito02() {
        double valorEsperado = 100;

        conta.realizarDeposito(100);

        assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("Altera senha da conta")
    public void testAlterarSenha01() {
        String senhaAntiga = "1234";
        String senhaNova = "teste";

        conta.setSenha(senhaAntiga);
        conta.alterarSenha(senhaAntiga, senhaNova);

        assertEquals(conta.getSenha(), senhaNova);
    }

    @Test
    @DisplayName("Nao permite alterar senha da conta")
    public void testAlterarSenha02() {
        String senhaAntiga = "1234";
        String senhaNova = "teste";
        String mensagem = "";

        try {
            conta.alterarSenha(senhaAntiga, senhaNova);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }


        assertEquals(mensagem, "Senha incorreta.");
    }


    @Test
    @DisplayName("Utiliza credito especial sem saldo")
    public void testCreditoEspecial01() {
        double valorEsperado = -1 * conta.getLimiteCreditoEspecial();

        conta.creditoEspecial();

        assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("Impede utilizar o credito especial pois possui saldo")
    public void testCreditoEspecial02() {
        String mensagem = "";

        conta.setSaldo(100);

        try {
            conta.creditoEspecial();
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce so pode usar o credito especial quando esta com exastos 0 R$.");
    }

    @Test
    @DisplayName("Impede utilizar o credito especial pois esta devendo")
    public void testCreditoEspecial03() {
        String mensagem = "";

        conta.setSaldo(-100);

        try {
            conta.creditoEspecial();
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce so pode usar o credito especial quando esta com exastos 0 R$.");
    }

    @Test
    @DisplayName("Utiliza credito especial saldo 0")
    public void testCreditoEspecial04() {
        double valorEsperado = -1 * conta.getLimiteCreditoEspecial();

        conta.setSaldo(0);
        conta.creditoEspecial();

        assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("Nao permite credito especial")
    public void testCreditoEspecial05() {
        String mensagem = "";

        conta.setSaldo(2456);

        try {
            conta.creditoEspecial();
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce so pode usar o credito especial quando esta com exastos 0 R$.");
    }

    @Test
    @DisplayName("Impede devedor de usar o credito especial")
    public void testCreditoEspecial06() {
        String mensagem = "";

        conta.setSaldo(-7685);

        try {
            conta.creditoEspecial();
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce so pode usar o credito especial quando esta com exastos 0 R$.");
    }

    @Test
    @DisplayName("Valida perguntas de seguranca")
    public void testPerguntaSeguranca01() {
        assertEquals(true, conta.perguntaSeguranca(conta.getPerguntaAnimal(), conta.getPerguntaCor(), conta.getPerguntaComida()));
    }

    @Test
    @DisplayName("Pergutnas de seguranca todas invalidas")
    public void testPerguntaSeguranca02() {
        String mensagem = "";

        try {
            conta.perguntaSeguranca("animal", "cor", "comida");
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Alguma pergunta esta errada. Operacao negada.");
    }

    @Test
    @DisplayName("Pergutnas de seguranca duas invalidas")
    public void testPerguntaSeguranca03() {
        String mensagem = "";

        try {
            conta.perguntaSeguranca(conta.getPerguntaAnimal(), "cor", "comida");
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Alguma pergunta esta errada. Operacao negada.");
    }

    @Test
    @DisplayName("Pergutnas de seguranca uma invalida")
    public void testPerguntaSeguranca04() {
        String mensagem = "";

        try {
            conta.perguntaSeguranca(conta.getPerguntaAnimal(), conta.getPerguntaCor(), "comida");
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Alguma pergunta esta errada. Operacao negada.");
    }

    @Test
    @DisplayName("Paga boleto corretamente")
    public void testBoleto01() {
        Boleto boleto = new Boleto(LocalDate.of(2024, 12, 2), 1000);
        conta.setSaldo(1000);
        conta.pagarBoleto(boleto);

        assertEquals(conta.getSaldo(), 0);
    }

    @Test
    @DisplayName("Sem saldo para pagar boleto")
    public void testBoleto02() {
        String mensagem = "";
        Boleto boleto = new Boleto(LocalDate.of(2024, 12, 2), 1000);

        try {
            conta.pagarBoleto(boleto);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Voce nao possui saldo suficiente.");
    }

    @Test
    @DisplayName("Boleto ja pago")
    public void testBoleto03() {
        String mensagem = "";
        Boleto boleto = new Boleto(LocalDate.of(2024, 12, 2), 1000);
        boleto.setPago(true);

        conta.setSaldo(10000);

        try {
            conta.pagarBoleto(boleto);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Esse boleto ja foi pago.");
    }

    @Test
    @DisplayName("Boleto vencido")
    public void testBoleto04() {
        String mensagem = "";
        Boleto boleto = new Boleto(LocalDate.of(2020, 12, 2), 1000);

        conta.setSaldo(10000);

        try {
            conta.pagarBoleto(boleto);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Esse boleto ja esta vencido.");
    }

    @Test
    @DisplayName("Boleto de valor negativo")
    public void testBoleto05() {
        String mensagem = "";
        conta.setSaldo(10000);

        try {
            Boleto boleto = new Boleto(LocalDate.of(2024, 12, 2), -20);
            boleto.setPago(true);
            conta.pagarBoleto(boleto);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Valor não pode ser menor que 0.");
    }

    @Test
    @DisplayName("Boleto de ontem")
    public void testBoleto06() {
        String mensagem = "";
        Boleto boleto = new Boleto(LocalDate.now().minusDays(1), 1000);

        conta.setSaldo(10000);

        try {
            conta.pagarBoleto(boleto);
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }

        assertEquals(mensagem, "Esse boleto ja esta vencido.");
    }

}