package uno;

import java.util.Stack;


public class Pilo {
    private Stack<Carta> cartes;


    public Pilo() {
        cartes = new Stack<>();
    }

    public Stack<Carta> getCartes() {
        return cartes;
    }
    public void addCarta(Carta carta) {
        cartes.push(carta);
    }

    public Carta agafarCarta(Carta carta) {
       return cartes.pop();
    }

    public Carta consultarCarta(){
        return cartes.peek();
    }








}
