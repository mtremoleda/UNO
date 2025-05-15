package uno.logica;
import uno.Partida;

public class CartaNumerica extends Carta {
    public CartaNumerica(Color color, int numero) {
        super(color, numero, "Numerica");
    }

    public void aplicarEfecte(Partida partida) {
        // les cartes numeriques no tenen efectes especials
    }
}
