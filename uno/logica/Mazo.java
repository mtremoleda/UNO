package uno.logica;

import java.util.Stack;
import java.util.Collections;

public class Mazo {
    public  Stack<Carta> cartes;
    public  Stack<Carta> cartesInicials;


    public Mazo() {
        cartes = new Stack<>();
        cartesInicials = new Stack<>();
        int i, j;
        for (i = 0; i < Carta.Color.values().length; i++) {
            // Afageix nomes una carta del numero 0 de cada color
            cartes.push(new Carta( Carta.Color.values()[i], 0));
            // Fa dos cartes de cada color del numero 1 al numero 9
            for (j = 1; j <= 9; j++) {
                cartes.push(new Carta(Carta.Color.values()[i] ,j));
                cartes.push(new Carta(Carta.Color.values()[i], j));
            }
        }
    }


    public Stack<Carta> getCartes() {
        return cartes;
    }

    public Carta afagarCarta() {
        return cartes.pop();
    }

    public void reiniciar(Pilo pilo) {
        // mou totes les cartes del pilo al mazo menys la ultima
        if (pilo.getCartes().size() > 1) {
            Stack<Carta> cartasPilo = new Stack<>();
            cartasPilo.addAll(pilo.getCartes());
            Carta ultimaCarta = cartasPilo.pop();
            while (!cartasPilo.isEmpty()) {
                cartes.push(cartasPilo.pop());
            }
            pilo.getCartes().clear();
            pilo.getCartes().push(ultimaCarta);
            barrejar();
        }
    }

    public void barrejar() {
        Collections.shuffle(cartes);
    }

    public boolean esBuit(){
        return cartes.isEmpty();
    }


}
