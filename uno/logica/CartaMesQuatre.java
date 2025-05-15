package uno.logica;
import uno.Partida;
import java.util.Scanner;

public class CartaMesQuatre extends Carta {
    public CartaMesQuatre() {
        super(Color.Negre, -1, "MésQuatre");
    }


    public void aplicarEfecte(Partida partida) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tria un color (1:Vermell, 2:Blau, 3:Verd, 4:Groc):");
        int opcio = scanner.nextInt();

        switch(opcio) {
            case 1: this.color = Color.Vermell; break;
            case 2: this.color = Color.Blau; break;
            case 3: this.color = Color.Verd; break;
            case 4: this.color = Color.Groc; break;
            default: this.color = Color.Vermell; break;
        }


        partida.getOrdreJugadors().passarTorn();
        Jugador seguent = partida.getOrdreJugadors().getJugadorActiu();
        for (int i = 0; i < 4; i++) {
            seguent.robarCarta(partida.getMazo());
        }
        System.out.println(seguent.getNom() + " ha robat 4 cartes!");
    }
}