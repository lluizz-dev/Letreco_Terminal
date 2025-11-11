package main.java; // Pacotes do projeto.
// Importando todas as classes neccesárias nativas do JDK.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList; // Importando o ArrayList.
import java.util.List; // Importando o List.
import java.util.Scanner; // Importando o Scanner para receber dados do usuário.
import java.util.Random;

/**
 * Controle - Classe que cuida da parte de organizar a logica das palavras.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */

public class Controle {

    private String palavraSecreta ; // Variável da palavra a ser descorberta
    private int numTentativas; // Número de tentativas do usuário, máximo é 6
    private List<Palavra> tentativas; // As tentativas do usuário em uma lista
    private boolean acertou;
    public static final String RESET = "\u001B[0m"; // Reset das cores.
    public static final String BG_VERDE = "\u001B[42m"; // Fundo verde.
    public static final String BG_AMARELO = "\u001B[43m"; // Fundo amarelo.
    public static final String BG_CINZA = "\u001B[47m"; // Fundo cinza.

    // Construtor do controle
    public Controle() {
        numTentativas = 0; // Inicializando o número de tentativas.
        tentativas = new ArrayList<>(); // Inicializando a lista das tentativas.
        setPalavraSecreta(); // Iniciando palavra secreta sendo aleatória.
    }

    /**
     * Método que recebe e verifica todas as tentativas do usuário e
     * por fim retorna se é true ou false para o verificador do Console.
     */
    public boolean receberPalavra() {
        Scanner input = new Scanner(System.in); // Instanciando o Scanner para obter um scanner para receber dados do usuário.
        String palavra = input.nextLine(); // Recebendo a palavra da usuário.

        Palavra tentativa = new Palavra(palavra, palavra.length()); // Instanciando a Classe da palavra para criar um objeto recebendo os atributos solicitandos antes ao usuário.

        // Verificador - Verifica o tamanho, existencia da palavra e se é obscena.
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
            tentativas.add(tentativa); // Se passa pelo verificador adiciona a palavra na lista das tentativas,
            numTentativas++; // Adiciona mais 1 ao número de tentativas e
            return true; // Retorna true.
        }

    }

    /**
     * Preciso de um metodo que depois de receber a palavra,
     * verifique se ela é igual a palavraSecreta
     */
    public void comparacao() {
        if (tentativas.get(tentativas.size() - 1).getLetras().equalsIgnoreCase(palavraSecreta)) {
            System.out.println(BG_VERDE + palavraSecreta + RESET);
            System.out.println("Parabéns! Você acertou!");
            setAcertou(true);
        }
        else {
            for (int i = 0; i < tentativas.size(); i++) {
                String tentativa = tentativas.get(i).getLetras().toLowerCase();
                String palavra = palavraSecreta.toLowerCase();

                for (int y = 0; y < tentativa.length(); y++) {
                    char letra = tentativa.charAt(y);

                    if (letra == palavra.charAt(y)) {
                        System.out.printf("%s %c %s", BG_VERDE, Character.toUpperCase(letra), RESET);
                    } else if (palavra.indexOf(letra) != -1) {
                        System.out.printf("%s %c %s", BG_AMARELO, Character.toUpperCase(letra), RESET);
                    } else {
                        System.out.printf("%s %c %s", BG_CINZA, Character.toUpperCase(letra), RESET);
                    }
                }
                System.out.println();
            }

        }
    }

    public int getNumTentativas() {
        return numTentativas;
    }

    //public Palavra getTentativas() {
    //    return tentativas;
    //}

    public void setAcertou(boolean num) {
        this.acertou = num;
    }

    public boolean getAcertou() {
        return acertou;
    }

    public void setPalavraSecreta() {
        try {
            Palavra palavra;
            Random random = new Random();
            int num;
            List<String> palavras = Files.readAllLines(Paths.get("src/main/resources/lexico.txt"));
            do {
                num = random.nextInt(palavras.size());
                palavraSecreta = palavras.get(num);
                palavra = new Palavra(palavraSecreta, palavraSecreta.length());
            } while (palavra.getTamanho() != 5 || palavra.palavraObscena());

        }
        catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }
}
