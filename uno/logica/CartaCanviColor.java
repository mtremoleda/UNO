package uno.logica;
import uno.Partida;

import java.util.Scanner;

public class CartaCanviColor extends Carta {
    public CartaCanviColor() {
        super(Color.Negre, -1, "CanviColor");
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

        System.out.println("Color canviat a: " + this.color);
    }
}