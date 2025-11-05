package main.java;
import java.util.List;

/**
 * Controle - Classe que cuida da parte de organizar a logica das palavras.
 *
 * @autoria Luiz Eduardo
 * @version 1.0
 */

public class Controle {

    private String palavraSecreta; //Variável da palavra a ser descorberta
    private int numTentativas;
    private List<Palavra> tentativas;

    public Controle() {

    }

    public void numTentativa(int tentativas) {
        if (tentativas >= 6) {
            //acabou o jogo
        }
    }


}
