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

}
