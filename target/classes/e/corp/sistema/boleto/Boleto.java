package e.corp.sistema.boleto;


import e.corp.sistema.exception.ValidacaoException;
import e.corp.sistema.gerador.GeradorDeCaracteres;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Boleto {

    private String codigo;
    private LocalDate vencimento;
    private LocalDate dataPagamento;
    private double valor;
    private boolean pago;

    public Boleto(LocalDate vencimento, double valor) {
        if (!validaValor(valor)) {
            throw new ValidacaoException("Valor nao pode ser menor que 0");
        }

        this.codigo = GeradorDeCaracteres.gerarNumero(48);
        this.vencimento = vencimento;
        this.valor = valor;
        this.pago = false;
    }

    public static boolean validaValor(double valor) {
        return (valor > 0);
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "codigo='" + codigo + '\'' +
                ", vencimento=" + vencimento +
                ", dataPagamento=" + dataPagamento +
                ", valor=" + valor +
                ", pago=" + pago +
                "}\n";
    }
}
