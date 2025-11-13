package main.java; // Pacote principal do projeto.

// Importações nativas necessárias para o funcionamento do jogo.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * Classe Controle
 * Responsável por gerenciar a lógica do jogo Letreco:
 * - Recebe e valida tentativas;
 * - Gera a palavra secreta;
 * - Faz a comparação entre palavras;
 * - Controla o número de tentativas e resultado.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */
public class Controle {

    private String palavraSecreta;      // Palavra que o jogador precisa descobrir.
    private int numTentativas;          // Contador de tentativas (máximo de 6).
    private List<Palavra> tentativas;   // Lista com todas as tentativas do jogador.
    private boolean acertou;            // Indica se o jogador acertou a palavra secreta.

    // Códigos ANSI para colorir a saída no terminal
    public static final String RESET = "\u001B[0m";
    public static final String BG_VERDE = "\u001B[42m";
    public static final String BG_AMARELO = "\u001B[43m";
    public static final String BG_BLACK = "\u001B[40m";

    /**
     * Construtor da classe Controle.
     * Inicializa as variáveis e define uma palavra secreta aleatória.
     */
    public Controle() {
        numTentativas = 0;
        tentativas = new ArrayList<>(); // Inicia a lista
        setPalavraSecreta(); // Define uma palavra secreta aleatória.
    }

    /**
     * Recebe uma tentativa do jogador e valida a palavra.
     * Retorna true se for válida, false caso contrário.
     */
    public boolean receberPalavra() {
        Scanner input = new Scanner(System.in);
        String palavra = input.nextLine(); // Lê a palavra digitada pelo jogador.

        // Cria um objeto Palavra para a tentativa.
        Palavra tentativa = new Palavra(palavra, palavra.length());

        // Validações:
        if (!tentativa.verificarTamanho()) {
            System.out.println("Tamanho inválido, digite uma palavra de 5 letras!");
            return false;
        } else if (!tentativa.existePalavra()) {
            System.out.println("Palavra não existe!");
            return false;
        } else if (tentativa.palavraObscena()) {
            System.out.println("Palavra obscena!");
            return false;
        } else {
            // Se passou em todas as validações:
            tentativas.add(tentativa);
            numTentativas++;
            return true;
        }
    }

    /**
     * Faz a comparação entre a tentativa atual e a palavra secreta.
     * Mostra o resultado com cores no terminal.
     */
    public void comparacao() {
        // Verifica se a tentativa mais recente é igual à palavra secreta.
        if (tentativas.get(tentativas.size() - 1).getLetras().equalsIgnoreCase(palavraSecreta)) {
            System.out.println(BG_VERDE + palavraSecreta + RESET);
            System.out.println("Parabéns! Você acertou!");
            setAcertou(true);
        } else {
            // Se ainda não acertou, percorre todas as tentativas anteriores.
            for (int i = 0; i < tentativas.size(); i++) {
                String tentativa = tentativas.get(i).getLetras().toLowerCase();
                String palavra = palavraSecreta.toLowerCase();

                // Compara letra por letra.
                for (int y = 0; y < tentativa.length(); y++) {
                    char letra = tentativa.charAt(y);

                    if (letra == palavra.charAt(y)) {
                        // Letra correta na posição certa → fundo verde.
                        System.out.printf("%s %c %s", BG_VERDE, Character.toUpperCase(letra), RESET);
                    } else if (palavra.indexOf(letra) != -1) {
                        // Letra existe mas está em outra posição → fundo amarelo.
                        System.out.printf("%s %c %s", BG_AMARELO, Character.toUpperCase(letra), RESET);
                    } else {
                        // Letra não existe na palavra secreta → fundo cinza.
                        System.out.printf("%s %c %s", BG_BLACK, Character.toUpperCase(letra), RESET);
                    }
                }
                System.out.println(); // Quebra de linha entre tentativas.
            }
        }
    }

    // Getters e Setters
    public int getNumTentativas() {
        return numTentativas;
    }

    public void setAcertou(boolean num) {
        this.acertou = num;
    }

    public boolean getAcertou() {
        return acertou;
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    /**
     * Define uma palavra secreta aleatória a partir do arquivo "lexico.txt".
     * Garante que a palavra tenha 5 letras e não seja obscena.
     */
    public void setPalavraSecreta() {
        // Usando um excessão para acessar a lista de palavras.
        try {
            Palavra palavra;
            Random random = new Random();
            int num;

            // Lê todas as palavras disponíveis.
            List<String> palavras = Files.readAllLines(Paths.get("src/main/resources/lexico.txt"));

            // Escolhe uma palavra aleatória válida.
            do {
                num = random.nextInt(palavras.size());
                palavraSecreta = palavras.get(num);
                palavra = new Palavra(palavraSecreta, palavraSecreta.length());
            } while (palavra.getTamanho() != 5 || palavra.palavraObscena());

        } catch (IOException e) { // Caso dê errado abrir o arquivo, a excessão é tratada.
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
