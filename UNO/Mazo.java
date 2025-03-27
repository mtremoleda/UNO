package UNO;

import java.util.Stack;
import java.util.Collections;

public class Mazo {
    private static Stack<Carta> cartes;
    private static Stack<Carta> cartesInicials;

    public Mazo() {
        cartes = new Stack<>();
        cartesInicials = new Stack<>();
        int i, j;
        for (i = 0; i < Carta.colors.values().length; i++) {
            // Afageix nomes una carta del numero 0 de cada color
            cartes.push(new Carta( Carta.colors.values()[i], 0));
            // Fa dos cartes de cada color del numero 1 al numero 9
            for (j = 1; j <= 9; j++) {
                cartes.push(new Carta(Carta.colors.values()[i] ,j));
                cartes.push(new Carta(Carta.colors.values()[i], j));
            }
        }
    }


    public Stack<Carta> getCartes() {
        return cartes;
    }

    public void afagarCarta(Carta carta) {
        cartes.push(carta);
    }

    public void reiniciar(Pilo pilo) {
        // mou totes les cartes del pilo al mazo menys la ultima
        if (pilo.getPilo().size() > 1) {
            Stack<Carta> cartasPilo = new Stack<>();
            cartasPilo.addAll(pilo.getPilo());
            Carta ultimaCarta = cartasPilo.pop();
            while (!cartasPilo.isEmpty()) {
                cartes.push(cartasPilo.pop());
            }
            pilo.getPilo().clear();
            pilo.getPilo().push(ultimaCarta);
            barrejar();
        }
    }

    public void barrejar() {
        Collections.shuffle(cartes);
    }
}
