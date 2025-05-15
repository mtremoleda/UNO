package uno.logica;

import uno.Partida;

public class CartaMesDos extends Carta {
    public CartaMesDos(Color color) {
        super(color, -1, "MésDos");
    }


    public void aplicarEfecte(Partida partida) {
        partida.getOrdreJugadors().passarTorn();
        Jugador seguent = partida.getOrdreJugadors().getJugadorActiu();
        for (int i = 0; i < 2; i++) {
            seguent.robarCarta(partida.getMazo());
        }
        System.out.println(seguent.getNom() + " ha robat 2 cartes!");
    }
}