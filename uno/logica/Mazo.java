package uno.logica;

import java.util.Stack;
import java.util.Collections;

public class Mazo {
    public  Stack<Carta> cartes;
    public  Stack<Carta> cartesInicials;


    public Mazo() {
        this.cartes = new Stack<>();
        this.cartesInicials = new Stack<>();


        // Cartes numèriques
        Carta.Color[] colors = Carta.Color.values();
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != Carta.Color.Negre) {
                // Una carta 0 per color
                cartes.push(new CartaNumerica(colors[i], 0));

                // Dues cartes del 1-9 per color
                for (int j = 1; j <= 9; j++) {
                    cartes.push(new CartaNumerica(colors[i], j));
                    cartes.push(new CartaNumerica(colors[i], j));
                }

                // Cartes +2 per color (2 per color)
                cartes.push(new CartaMesDos(colors[i]));
                cartes.push(new CartaMesDos(colors[i]));

                // Cartes prohibit per color (2 per color)
                cartes.push(new CartaProhibit(colors[i]));
                cartes.push(new CartaProhibit(colors[i]));

                // Cartes canvi sentit per color (2 per color)
                cartes.push(new CartaCanviSentit(colors[i]));
                cartes.push(new CartaCanviSentit(colors[i]));
            }
        }

        // Cartes especials negres (4 de cada)
        for (int i = 0; i < 4; i++) {
            cartes.push(new CartaCanviColor());
            cartes.push(new CartaMesQuatre());
        }

        barrejar();
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
