package e.corp.sistema.transacao;


import e.corp.sistema.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Transacao {

    private static int id;
    private Cliente clienteRemetente;
    private Cliente clienteDestinatario;
    private TipoTransacao tipoTransacao;
    private double valor;
    private LocalDate data;

<<<<<<< HEAD
    public Transacao(Cliente clienteRemetente, Cliente clienteDestinatario, TipoTransacao tipoTransacao, double valor) {
=======
    public Transacao(Cliente clienteRemetente,
                     Cliente clienteDestinatario,
                     TipoTransacao tipoTransacao, double valor) {
>>>>>>> d7cca2f838a493a8092535a46097eec0b5b4f41e
        id++;
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
