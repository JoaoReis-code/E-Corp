package e.corp.sistema.cliente;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static e.corp.sistema.cliente.Cliente.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClienteTest {

    private Cliente cliente;


    @Test
    @DisplayName("Valida idade maior que 18")
    public void testValidarIdade01() {
        assertTrue(validarIdade(LocalDate.now().minusYears(20)));
    }

    @Test
    @DisplayName("Valida idade igual a 18")
    public void testValidarIdade02() {
        assertFalse(validarIdade(LocalDate.now().minusYears(18)));
    }

    @Test
    @DisplayName("Valida idade menor a 18")
    public void testValidarIdade03() {
        assertFalse(validarIdade(LocalDate.now()));
    }

    @Test
    @DisplayName("Valida idade muito maior que 18")
    public void testValidarIdade04() {
        assertTrue(validarIdade(LocalDate.now().minusYears(149)));
    }

    @Test
    @DisplayName("Valida idade igual a 18 e 1 dia")
    public void testValidarIdade05() {
        assertTrue(validarIdade(LocalDate.now().minusYears(18).minusDays(1)));
    }

    @Test
    @DisplayName("Valida idade que nem nasceu")
    public void testValidarIdade06() {
        assertFalse(validarIdade(LocalDate.now().plusYears(76)));
    }

    @Test
    @DisplayName("Valida cpf formato apenas numeros")
    public void testValidarCpf01() {
        assertTrue(validarCpf("11122233344"));
    }

    @Test
    @DisplayName("Valida cpf mais numeros")
    public void testValidarCpf02() {
        assertFalse(validarCpf("111222333441023"));
    }

    @Test
    @DisplayName("Valida cpf menos numeros")
    public void testValidarCpf03() {
        assertFalse(validarCpf("1112223"));
    }

    @Test
    @DisplayName("Valida cpf com letras")
    public void testValidarCpf04() {
        assertFalse(validarCpf("abcefghijk"));
    }

    @Test
    @DisplayName("Valida cpf com letras e numero")
    public void testValidarCpf05() {
        assertFalse(validarCpf("a2ce4g3ij5"));
    }

    @Test
    @DisplayName("Valida cpf formato apenas numeros")
    public void testValidarCpf06() {
        assertTrue(validarCpf("11122233344"));
    }

    @Test
    @DisplayName("Valida cpf mais numeros")
    public void testValidarCpf07() {
        assertFalse(validarCpf("111222333441023"));
    }

    @Test
    @DisplayName("Valida cpf menos numeros")
    public void testValidarCpf08() {
        assertFalse(validarCpf("1112223"));
    }

    @Test
    @DisplayName("Valida cpf com letras")
    public void testValidarCpf09() {
        assertFalse(validarCpf("abcefghijk"));
    }

    @Test
    @DisplayName("Valida cpf com letras e numero")
    public void testValidarCpf10() {
        assertFalse(validarCpf("a2ce4g3ij5"));
    }

    @Test
    @DisplayName("Valida cpf com formato de apenas numeros")
    public void testValidarCpf11() {
        assertTrue(validarCpf("12345678910"));
    }

    @Test
    @DisplayName("Valida cpf com mais numeros")
    public void testValidarCpf12() {
        assertFalse(validarCpf("134436537573534242436023"));
    }

    @Test
    @DisplayName("Valida cpf sem numeros")
    public void testValidarCpf13() {
        assertFalse(validarCpf(""));
    }

    @Test
    @DisplayName("Valida cpf com caracteres especiais")
    public void testValidarCpf14() {
        assertFalse(validarCpf("#@$@%@$%@~!#%#$%"));
    }

    @Test
    @DisplayName("Valida cpf com letras, numeros e caracteres especiais")
    public void testValidarCpf15() {
        assertFalse(validarCpf("a2ce#$^%4g34#%j5"));
    }

    @Test
    @DisplayName("Valida email formato correto")
    public void testValidarEmail01() {
        assertTrue(validarEmail("teste@gmail.com"));
    }

    @Test
    @DisplayName("Valida email sem arroba")
    public void testValidarEmail02() {
        assertFalse(validarEmail("teste2gmail.com"));
    }

    @Test
    @DisplayName("Valida email com arroba no primeiro digito")
    public void testValidarEmail03() {
        assertFalse(validarEmail("@gmail.com"));
    }

    @Test
    @DisplayName("Valida email com caractere especial no primeiro digito")
    public void testValidarEmail04() {
        assertFalse(validarEmail("@##$@gmail.com"));
    }

    @Test
    @DisplayName("Valida email sem nada")
    public void testValidarEmail05() {
        assertFalse(validarEmail(""));
    }

    @Test
    @DisplayName("Renda mensal valida")
    public void testValidarRendaMensal01() {
        assertTrue(validaRendaMensal(1000));
    }

    @Test
    @DisplayName("Renda mensal invalida")
    public void testValidarRendaMensal02() {
        assertFalse(validaRendaMensal(-100));
    }

    @Test
    @DisplayName("Sem renda mensal")
    public void testValidarRendaMensal03() {
        assertFalse(validaRendaMensal(0));
    }

    @Test
    @DisplayName("Renda mensal valida muito alta")
    public void testValidarRendaMensal04() {
        assertTrue(validaRendaMensal(78979878));
    }

    @Test
    @DisplayName("Renda mensal negativa")
    public void testValidarRendaMensal05() {
        assertFalse(validaRendaMensal(-6969));
    }

    @Test
    @DisplayName("Renda mensal de zero negativo")
    public void testValidarRendaMensal06() {
        assertFalse(validaRendaMensal(-0));
    }

    @Test
    @DisplayName("Renda mensal valida porem baixa")
    public void testValidarRendaMensal07() {
        assertTrue(validaRendaMensal(5));
    }

}