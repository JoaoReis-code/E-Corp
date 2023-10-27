package e.corp.sistema.boleto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static e.corp.sistema.boleto.Boleto.validaValor;
import static org.junit.jupiter.api.Assertions.*;

class BoletoTest {
    @Test
    @DisplayName("Valida valor positivo para o boleto")
    public void testBoleto01(){
        assertTrue(validaValor(10));
    }

    @Test
    @DisplayName("Valida valor negativo para o boleto")
    public void testBoleto02(){
        assertFalse(validaValor(-10));
    }
}