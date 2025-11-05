package main.java;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

/**
 * Palavra - Classe que representa a palavra de cada tentativa e verificação dela;
 *
 * @autoria Luiz Eduardo
 * @version 1.0
 */

public class Palavra {
    private String letras;
    private int tamanho;

    public Palavra(String letras, int tamanho) {
        this.letras = letras;
        this.tamanho = tamanho;
    }

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

    public boolean verificarTamanho() {
        if (tamanho == 5) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean existePalavra() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src/Jogo/resources/lexico.txt"));

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

    public boolean palavraObsena() {
        try {
            List<String> obsenas = Files.readAllLines(Paths.get("src/Jogo/resources/negativas.txt"));

            // Verifica se a palavra está na lista de palavras obsenas.
            for (String linha : obsenas) {
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
