package e.corp.sistema.cliente;

import e.corp.sistema.exception.ValidacaoException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimeto;
    private Sexo sexo;
    private double rendaMensal;

    public Cliente(String nome, String cpf, String email, LocalDate dataNascimeto, Sexo sexo, double rendaMensal) {

        if (!validarCpf(cpf)) {
            throw new ValidacaoException("Formato de Cpf incorreto. Informe apenas os numeros.");
        } else if (!validarIdade(dataNascimeto)) {
            throw new ValidacaoException("Apenas com mais de 18 anos e 1 dia e menos de 150 anos podem ser clientes.");
        } else if (!validarEmail(email)) {
            throw new ValidacaoException("Insira um email valido.");
        } else if (!validaRendaMensal(rendaMensal)) {
            throw new ValidacaoException("Voce precisa ter alguma renda mensal para ser cliente.");
        } else {
            this.nome = nome;
            this.sexo = sexo;
            this.email = email;
            this.dataNascimeto = dataNascimeto;
            this.cpf = cpf;
            this.rendaMensal = rendaMensal;
        }
    }

    public static boolean validarIdade(LocalDate dataFornecida) {
        LocalDate dataAtual = LocalDate.now().minusYears(18);
        LocalDate dataAtual2 = LocalDate.now().minusYears(150);
        return (dataAtual.isAfter(dataFornecida) && dataAtual2.isBefore(dataFornecida));
    }

    public static boolean validarCpf(String cpf) {
        return ((cpf.length() == 11) && (cpf.matches("[0-9]*")));
    }

    public static boolean validarEmail(String email) {
        return (email.indexOf('@') > 0);
    }

    public static boolean validaRendaMensal(double rendaMensal) {
        return (rendaMensal > 0);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome = '" + nome + '\'' +
                ", cpf = '" + cpf + '\'' +
                ", email = '" + email + '\'' +
                ", dataNascimeto = " + dataNascimeto +
                ", sexo = " + sexo +
                ", rendaMensal = " + rendaMensal +
                "}\n";
    }
}
