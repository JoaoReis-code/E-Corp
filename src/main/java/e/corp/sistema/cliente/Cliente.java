package e.corp.sistema.cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import e.corp.sistema.exception.ValidacaoException;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimeto;
    private Sexo sexo;
    private double rendaMensal;

    public Cliente(String nome, String cpf, String email, LocalDate dataNascimeto, Sexo sexo, double rendaMensal) {

        if(!validarCpf(cpf)){
            throw new ValidacaoException("Formato de Cpf incorreto. Informe apenas os numeros.");
        }else if(!validarIdade(dataNascimeto)){
            throw new ValidacaoException("Apenas maiores de 18 anos podem ser clientes.");
        }else if (!validarEmail(email)) {
            throw new ValidacaoException("Insira um email valido.");
        }else if(!validaRendaMensal(rendaMensal)){
            throw new ValidacaoException("Voce precisa ter alguma renda mensal para ser cliente.");
        }else{
            this.nome = nome;
            this.sexo = sexo;
            this.email = email;
            this.dataNascimeto = dataNascimeto;
            this.cpf = cpf;
            this.rendaMensal = rendaMensal;
        }
    }

    public boolean validarIdade(LocalDate dataFornecida){
        LocalDate dataAtual = LocalDate.now().minusYears(18);
        return dataAtual.isAfter(dataFornecida);
    }

    public boolean validarCpf(String cpf){
        return ((cpf.length() == 11) && (cpf.matches("[0-9]*")));
    }

    public boolean validarEmail(String email){
        return ( email.indexOf('@') > 0 );
    }

    public boolean validaRendaMensal(double rendaMensal){
        return (rendaMensal>0);
    }
}
