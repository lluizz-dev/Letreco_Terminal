package main.java; // Pacotes do projeto.
// Importando todas as classes neccesárias nativas do JDK.
import java.util.ArrayList; // Importando o ArrayList.
import java.util.List; // Importando o List.
import java.util.Scanner; // Importando o Scanner para receber dados do usuário.

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

    // Construtor do controle
    public Controle() {
        palavraSecreta = "Minto"; // Defenindo a palavra secreta.
        numTentativas = 0; // Inicializando o número de tentativas.
        tentativas = new ArrayList<>(); // Inicializando a lista das tentativas.
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
}
