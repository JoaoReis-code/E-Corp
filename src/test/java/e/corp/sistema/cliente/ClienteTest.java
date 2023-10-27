package e.corp.sistema.cliente;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static e.corp.sistema.cliente.Cliente.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;



    @Test
    @DisplayName("Valida idade maior que 18")
    public void testValidarIdade01(){
        assertTrue(validarIdade(LocalDate.now().minusYears(20)));
    }

    @Test
    @DisplayName("Valida idade igual a 18")
    public void testValidarIdade02(){
        assertFalse(validarIdade(LocalDate.now().minusYears(18)));
    }

    @Test
    @DisplayName("Valida idade menor a 18")
    public void testValidarIdade03(){
        assertFalse(validarIdade(LocalDate.now()));
    }

    @Test
    @DisplayName("Valida cpf formato apenas numeros")
    public void testValidarCpf01(){
        assertTrue(validarCpf("11122233344"));
    }

    @Test
    @DisplayName("Valida cpf mais numeros")
    public void testValidarCpf02(){
        assertFalse(validarCpf("111222333441023"));
    }

    @Test
    @DisplayName("Valida cpf menos numeros")
    public void testValidarCpf03(){
        assertFalse(validarCpf("1112223"));
    }

    @Test
    @DisplayName("Valida cpf com letras")
    public void testValidarCpf04(){
        assertFalse(validarCpf("abcefghijk"));
    }

    @Test
    @DisplayName("Valida cpf com letras e numero")
    public void testValidarCpf05(){
        assertFalse(validarCpf("a2ce4g3ij5"));
    }

    @Test
    @DisplayName("Valida email formato correto")
    public void testValidarEmail01(){
        assertTrue(validarEmail("teste@gmail.com"));
    }

    @Test
    @DisplayName("Valida email sem arroba")
    public void testValidarEmail02(){
        assertFalse(validarEmail("teste2gmail.com"));
    }

    @Test
    @DisplayName("Valida email com arroba no primeiro digito")
    public void testValidarEmail03(){
        assertFalse(validarEmail("@gmail.com"));
    }

    @Test
    @DisplayName("Renda mensal valida")
    public void testValidarRendaMensal01(){
        assertTrue(validaRendaMensal(1000));
    }

    @Test
    @DisplayName("Renda mensal invalida")
    public void testValidarRendaMensal02(){
        assertFalse(validaRendaMensal(-100));
    }

    @Test
    @DisplayName("Sem renda mensal")
    public void testValidarRendaMensal03(){
        assertFalse(validaRendaMensal(0));
    }
}