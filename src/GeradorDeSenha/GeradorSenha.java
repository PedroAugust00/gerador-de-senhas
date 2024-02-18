package GeradorDeSenha;

import java.util.Random;
import java.util.Scanner;

public class GeradorSenha {

    private static final String CARACTERES_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CARACTERES_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$%^&*()-+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("**Gerador de Senha**");
        System.out.println("---------------------");

        // Tamanho da senha
        System.out.print("Digite o tamanho da senha (8-32 caracteres): ");
        int tamanho = scanner.nextInt();

        // Incluir letras maiúsculas?
        System.out.print("Incluir letras maiúsculas (s/n)? ");
        boolean maiusculas = scanner.next().equalsIgnoreCase("s");

        // Incluir letras minúsculas?
        System.out.print("Incluir letras minúsculas (s/n)? ");
        boolean minusculas = scanner.next().equalsIgnoreCase("s");

        // Incluir números?
        System.out.print("Incluir números (s/n)? ");
        boolean numeros = scanner.next().equalsIgnoreCase("s");

        // Incluir símbolos?
        System.out.print("Incluir símbolos (s/n)? ");
        boolean simbolos = scanner.next().equalsIgnoreCase("s");

        // Validar opções
        if (!maiusculas && !minusculas && !numeros && !simbolos) {
            System.out.println("Erro: pelo menos um tipo de caractere deve ser selecionado.");
            return;
        }

        // Gerar senha
        String senha = gerarSenha(tamanho, maiusculas, minusculas, numeros, simbolos);

        // Exibir senha
        System.out.println("Senha gerada: " + senha);
    }

    private static String gerarSenha(int tamanho, boolean maiusculas, boolean minusculas, boolean numeros, boolean simbolos) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        String caracteres = "";

        if (maiusculas) {
            caracteres += CARACTERES_MAIUSCULAS;
        }

        if (minusculas) {
            caracteres += CARACTERES_MINUSCULAS;
        }

        if (numeros) {
            caracteres += NUMEROS;
        }

        if (simbolos) {
            caracteres += SIMBOLOS;
        }

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            builder.append(caracteres.charAt(index));
        }

        return builder.toString();
    }
}
