package uno.logica;
import uno.Partida;
public class CartaCanviSentit extends Carta {
    public CartaCanviSentit(Color color) {
        super(color, -1, "CanviSentit");
    }

    public void aplicarEfecte(Partida partida) {
        partida.getOrdreJugadors().invertirOrdre();
        System.out.println("El sentit del joc ha canviat!");
    }
}