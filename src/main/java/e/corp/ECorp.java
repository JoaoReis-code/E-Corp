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
        Conta conta = new Conta(c,tipoConta,perguntaCor,perguntaComida,perguntaAnimal);
        conta.setNumeroDaConta("1234");
        conta.setSenha("admin123");
        conta.realizarDeposito(100);
        conta.realizarSaque(100);
        System.out.println(conta.getSaldo());
        Crud.add(c);
        Crud.add(conta);

        Cliente c2 = new Cliente(nome, cpf, email, dataNascimento, sexo,rendaMensal);
        Conta conta2 = new Conta(c,tipoConta,perguntaCor,perguntaComida,perguntaAnimal);
        conta2.getCliente().setCpf("11122233345");
        conta2.setNumeroDaConta("12345");
        conta2.setSenha("admin1234");
        Crud.add(c2);
        Crud.add(conta2);
        System.out.println(Crud.contas());
    }
}
