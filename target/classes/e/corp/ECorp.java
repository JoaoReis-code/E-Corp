/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package e.corp;


import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.interfaces.TelaLogin;
import e.corp.sistema.conta.TipoConta;
import e.corp.sistema.crud.Crud;

import java.time.LocalDate;

/**
 * @author Jz
 */
public class ECorp {

    public static Conta contaLogada;

    public static void main(String[] args) {
        System.out.println("Hello World!");

        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);

        String nome = "Joao";
        String cpf = "11122233344";
        String email = "dgbdb@dfdfd";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.FEMININO;
        double rendaMensal = 2544;

        TipoConta tipoConta = TipoConta.POUPANCA;
        String perguntaCor = "preto";
        String perguntaComida = "comida";
        String perguntaAnimal = "animal";

        Cliente c = new Cliente(nome, cpf, email, dataNascimento, sexo,rendaMensal);
        Crud.add(c);
        Crud.add(new Conta(c,tipoConta,perguntaCor,perguntaComida,perguntaAnimal));
        System.out.println(Crud.contas());
    }
}
