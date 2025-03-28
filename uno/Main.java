package uno;

import uno.interficie.UI;

public class Main {
    public static void main(String[] args) {

        Mazo mazo = new Mazo();
        mazo.barrejar();


        Pilo pilo = new Pilo();

        Jugador j1 = new Jugador("Jugador 1");


        System.out.println("Cartas del Mazo:");

        for (int i = 0; i < mazo.getCartes().size(); i++) {
            UI.mostrarCarta(mazo.getCartes().get(i));
        }

        System.out.println("Cartas del Jugador1");
        for (int i = 0; i < 7; i++){
            j1.addCarta(mazo.afagarCarta());
        }
        UI.mostrarCartes(j1.getCartes());

        System.out.println("Cartas del Mazo despres de repertir:");

        for (int i = 0; i < mazo.getCartes().size(); i++) {
            UI.mostrarCarta(mazo.getCartes().get(i));
        }
    }
}