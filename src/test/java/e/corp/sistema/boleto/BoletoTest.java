package e.corp.sistema.boleto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static e.corp.sistema.boleto.Boleto.validaValor;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoletoTest {
    @Test
    @DisplayName("Valida valor positivo para o boleto")
    public void testBoleto01() {
        assertTrue(validaValor(10));
    }

    @Test
    @DisplayName("Valida valor negativo para o boleto")
    public void testBoleto02() {
        assertFalse(validaValor(-10));
    }

    @Test
    @DisplayName("Valida valor positivo alto para o boleto")
    public void testBoleto03() {
        assertTrue(validaValor(25000));
    }

    @Test
    @DisplayName("Valida valor nulo para o boleto")
    public void testBoleto04() {
        assertFalse(validaValor(0));
    }

    @Test
    @DisplayName("Valida valor negativo baixo para o boleto")
    public void testBoleto05() {
        assertFalse(validaValor(-1000));
    }
}