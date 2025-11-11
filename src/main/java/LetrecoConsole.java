package main.java; // Pacotes do projeto.
import java.util.Scanner; // Importando o scanner para receber dados do usuário.

/**
 * Console - Classe que representa tudo visualmente no terminal;
 *
 * @author Luiz Eduardo
 * @version 1.0
 */

// Classe do LetrosoConsole
public class LetrecoConsole {

    // Códigos ANSI para background de todas as tentativas
    public static final String RESET = "\u001B[0m"; // Reset das cores.
    public static final String BG_VERMELHO = "\u001B[41m"; // Fundo Vermelho.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            Controle controle = new Controle(); // Instanciando um controle para coordenar o jogo.
            boolean verificacaoPalavra; // Verificador da palavra para liberar a comparador.

            // Mensagens de início do jogo.
            System.out.println("Bem vindo ao Letroso!");
            System.out.println("Tente acertar a palavra com 5 letras em 6 tentativas!");

            do {
                // Looping para a tentativa entrada de tentativa e validação da mesma.
                do {
                    System.out.printf("\nDigite a sua %d° tentativa: ", controle.getNumTentativas() + 1);
                    if (controle.receberPalavra()) { // O controle chama o método de receber a palavra e devolve um booleano com a verificação feita.
                        verificacaoPalavra = true; // A verificação recebe true, sendo assim consegue sair do looping com a palavra completamente validada.
                    } else {
                        verificacaoPalavra = false; // A verificação recebe false, então significa que a palavra foi inválida e o usuario irar tenta novamente.
                        System.out.println("Tente novamente!");
                    }
                } while (!verificacaoPalavra); // Laço do loopinp, mantendo o usuário preso a cada tentativa inválida.

                controle.comparacao();

                if (controle.getAcertou()) {
                    break;
                } else if (controle.getNumTentativas() == 6) {
                    System.out.println("\n" + BG_VERMELHO + "Perdeu! Tente novamente!" + RESET);
                    System.out.printf("A palavra era %s", controle.getPalavraSecreta());
                }
            } while (controle.getNumTentativas() < 6);
            System.out.println();
            System.out.println("Quer jogar novamente?");
            System.out.println("0 - Não \n1 - Sim");
            opcao = input.nextInt();
        } while (opcao == 1);
    }


}
