package main.java; // Pacotes do projeto.
// Importando todas as classes neccesárias nativas do JDK.
import java.nio.file.Files; // Importando o Files para arquivos.
import java.nio.file.Paths; // Importando o Paths para consultas em arquivos.
import java.util.List; // Importando o List para listas
import java.io.IOException; // Importando o IOException para manipular as exceções.

/**
 * Palavra - Classe que representa a palavra de cada tentativa e verificação dela;
 *
 * @autoria Luiz Eduardo
 * @version 1.0
 */

public class Palavra {

    private String letras; // Atributo para palavra.
    private int tamanho; // Atributo para o tamanho da palavra.

    // Construtor da Palavra
    public Palavra(String letras, int tamanho) {
        this.letras = letras; // Recebe a palavra por parâmetro.
        this.tamanho = tamanho; // E recebe o tamanho por parâmetro.
    }

    /**
     * Método que mostra as palavras na lista de palavras.
     */
    public void todasPalavras(){
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src/Jogo/resources/lexico.txt"));

            // Imprimir todas as linhas
            for (String linha : linhas) {
                System.out.println(linha);
            }
        }
        catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Método que verifica o tamanho da palavra.
     *
     */
    public boolean verificarTamanho() {
        if (tamanho == 5) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Método que verifica a existência da palavra.
     */
    public boolean existePalavra() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src/main/resources/lexico.txt"));

            // Verifica se a palavra existe na lista de palavras existentes
            for (String linha : linhas) {
                if (linha.equalsIgnoreCase(letras)) {
                    return true;
                }
            }
            return false;
        }
        catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método que verifica se a palvra é obscena.
     */
    public boolean palavraObscena() {
        try {
            List<String> obscenas = Files.readAllLines(Paths.get("src/main/resources/negativas.txt"));

            // Verifica se a palavra está na lista de palavras obsenas.
            for (String linha : obscenas) {
                if (linha.equalsIgnoreCase(letras)) {
                    return true;
                }
            }
            return false;
        }
        catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return false;
        }
    }
}
