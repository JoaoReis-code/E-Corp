package e.corp.sistema.boleto;


import e.corp.sistema.exception.ValidacaoException;
import e.corp.sistema.gerador.GeradorDeCaracteres;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class Boleto {

    private String codigo;
    private LocalDate vencimento;
    private LocalDate dataPagamento;
    private double valor;
    private boolean pago;

    public Boleto(LocalDate vencimento, double valor){
        if(!validaValor(valor)){
            throw new ValidacaoException("Valor nao pode ser menor que 0");
        }

        this.codigo = GeradorDeCaracteres.gerarNumero(48);
        this.vencimento = vencimento;
        this.valor = valor;
        this.pago = false;
    }

    public boolean validaValor(double valor){
        return (valor>0);
    }

}
