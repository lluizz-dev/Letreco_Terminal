package main.java;
import java.util.Scanner;

/**
 * Console - Classe que representa tudo visualmente no terminal;
 *
 * @autoria Luiz Eduardo
 * @version 1.0
 */

public class LetrecoConsole {
    public static void main() {
        Scanner input = new Scanner(System.in);
        boolean existe, obsena, tamanho;

        System.out.println("Bem vindo ao Jogo!");
        System.out.println("Tente acertar a palavra de 5 letras em 6 tentativas!");

        System.out.println("Digite a sua primeira tentativa: ");
        String termo = input.nextLine();

        Palavra palavra = new Palavra(termo, termo.length());

        System.out.println("\u001B[42m" + "A" + "\u001B[0m"); //Exemplo

        existe = palavra.existePalavra();
        obsena = palavra.palavraObsena();
        tamanho = palavra.verificarTamanho();
        if (existe) {
            System.out.println("Palavra existe!");
        }
        else {
            System.out.println("Palavra não está na lista de palavras!");
        }
        if (obsena) {
            System.out.println("Palavra obsena!");
        }
        else {
            System.out.println("Palavra não está na lista de obsenas!");
        }
        if (tamanho) {
            System.out.println("Palavra tem 5 letras!");
        }
        else {
            System.out.println("Palavra não tem 5 letras!");
        }
    }

}
