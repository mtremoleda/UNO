package UNO;

import java.util.Stack;

public class Pilo {
    private Stack<Carta> pilo;

    public Pilo() {
        pilo = new Stack<>();
    }

    public Stack<Carta> getPilo() {
        return pilo;
    }

    public void tirarCarta(Carta c) {
        pilo.push(c);
    }

    public void buidarPilo(Carta ultimaCarta) {
        pilo.clear();
        pilo.push(ultimaCarta); // Deixa la ultima carta al pilo
    }
}
