package e.corp.sistema.transacao;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import e.corp.sistema.cliente.Cliente;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class Transacao {

    private static int id;
    private Cliente clienteRemetente;
    private Cliente clienteDestinatario;
    private TipoTransacao tipoTransacao;
    private double valor;
    private LocalDate data;

    public Transacao(Cliente clienteRemetente, Cliente clienteDestinatario, TipoTransacao tipoTransacao, double valor){
        id ++;
        this.clienteRemetente = clienteRemetente;
        this.clienteDestinatario = clienteDestinatario;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.data = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Transacao{\n" +
                "clienteRemetente = " + clienteRemetente +
                ", clienteDestinatario = " + clienteDestinatario +
                ", tipoTransacao = " + tipoTransacao +
                ", valor = " + valor +
                ", data = " + data +
                "}\n";
    }
}
