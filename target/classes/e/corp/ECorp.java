/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package e.corp;


import e.corp.interfaces.TelaLogin;
import e.corp.sistema.boleto.Boleto;
import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.conta.TipoConta;
import e.corp.sistema.crud.Crud;

import java.time.LocalDate;

/**
 * @author Jz
 */
public class ECorp {

    public static Conta contaLogada;

    public static void main(String[] args) {

        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);

        String nome = "admin1";
        String cpf = "11122233344";
        String email = "teste@gmail.com";
        LocalDate dataNascimento = LocalDate.now().minusYears(20);
        Sexo sexo = Sexo.MASCULINO;
        double rendaMensal = 2500;

        TipoConta tipoConta = TipoConta.POUPANCA;
        String perguntaCor = "preto";
        String perguntaComida = "macarrao";
        String perguntaAnimal = "cachorro";

        Cliente c = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        Conta conta = new Conta(c, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);
        conta.setNumeroDaConta("123456");
        conta.setSenha("admin123");

        Crud.add(c);
        Crud.add(conta);

        String nome2 = "admin2";
        String cpf2 = "12345678910";
        String email2 = "teste2@gmail.com";
        LocalDate dataNascimento2 = LocalDate.now().minusYears(22);
        Sexo sexo2 = Sexo.FEMININO;
        double rendaMensal2 = 2500;

        TipoConta tipoConta2 = TipoConta.CORRENTE;
        String perguntaCor2 = "azul";
        String perguntaComida2 = "abobora";
        String perguntaAnimal2 = "gato";
        Cliente c2 = new Cliente(nome, cpf, email, dataNascimento, sexo, rendaMensal);
        Conta conta2 = new Conta(c, tipoConta, perguntaCor, perguntaComida, perguntaAnimal);
        conta2.setNumeroDaConta("654321");
        conta2.setSenha("123admin");
        Crud.add(c2);
        Crud.add(conta2);

        Boleto boleto1 = new Boleto(LocalDate.of(2024, 12, 2), 1000);
        Boleto boleto2 = new Boleto(LocalDate.of(2020, 12, 2), 200);
        Boleto boleto3 = new Boleto(LocalDate.of(2024, 12, 2), 122);
        Boleto boleto4 = new Boleto(LocalDate.of(2020, 12, 2), 840);
        boleto4.setPago(true);
        Boleto boleto5 = new Boleto(LocalDate.of(2024, 12, 2), 20000);
        Crud.add(boleto1);
        Crud.add(boleto2);
        Crud.add(boleto3);
        Crud.add(boleto4);
        Crud.add(boleto5);

    }
}
