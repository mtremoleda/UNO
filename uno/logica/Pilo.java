package uno.logica;

import java.util.Stack;


public class Pilo {
    public  Stack<Carta> cartes;


    public Pilo() {
        cartes = new Stack<>();
    }

    public Stack<Carta> getCartes() {
        return cartes;
    }
    public void addCarta(Carta carta) {
        cartes.push(carta);
    }

    public Carta consultarCarta(){
        return cartes.peek();
    }

    public Carta agafarCarta() {
        return cartes.pop();
    }


}
