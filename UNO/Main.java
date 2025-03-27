package UNO;

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
        for (Carta c : mazo.getCartes()){
            j1.addCarta(c);
        }
        UI.mostrarCartes(j1.getCartes());
    }
}