package uno.logica;
import uno.Partida;

public class CartaProhibit extends Carta {
    public CartaProhibit(Color color) {
        super(color, -1, "Prohibit");
    }


    public void aplicarEfecte(Partida partida) {
        partida.getOrdreJugadors().passarTorn();
        System.out.println("El seguent jugador ha perdut el seu torn!");
        partida.getOrdreJugadors().passarTorn();
    }
}