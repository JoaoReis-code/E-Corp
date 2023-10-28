package e.corp.sistema.gerador;

import java.util.Random;

public class GeradorDeCaracteres {

    private static final String[] caracteres = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"
    };

    private static final String[] numeros = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };

    public static String gerarSenha(int tamanho) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(caracteres[random.nextInt(caracteres.length)]);
        }

        return stringBuilder.toString();
    }

    public static String gerarNumero(int tamanho) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(numeros[random.nextInt(numeros.length)]);
        }

        return stringBuilder.toString();
    }
}