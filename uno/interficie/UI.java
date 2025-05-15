package uno.interficie;

import uno.logica.Carta;
import java.util.ArrayList;

public class UI {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String BLACK = "\u001B[30m";
    public static final String WHITE_BG = "\u001B[47m";

    private static String pintarCarta(Carta carta) {
        String colorCode = "";
        String topText = "";
        String centerText = "  UNO   ";
        String bottomText = "";


        switch (carta.getColor()) {
            case Groc:
                colorCode = YELLOW;
                break;
            case Vermell:
                colorCode = RED;
                break;
            case Blau:
                colorCode = BLUE;
                break;
            case Verd:
                colorCode = GREEN;
                break;
            case Negre:
                colorCode = BLACK + WHITE_BG;
                break;
            default:
                colorCode = RESET;
        }


        if (carta.getTipus() != null) {
            switch (carta.getTipus()) {
                case "MésDos":
                    topText = "+2";
                    centerText = "  +2   ";
                    bottomText = "+2";
                    break;
                case "Prohibit":
                    topText = " X";
                    centerText = " PRO ";
                    bottomText = " X";
                    break;
                case "CanviSentit":
                    topText = " R";
                    centerText = " REV ";
                    bottomText = " R";
                    break;
                case "MésQuatre":
                    topText = "+4";
                    centerText = "  +4   ";
                    bottomText = "+4";
                    break;
                case "CanviColor":
                    topText = " C";
                    centerText = " COL ";
                    bottomText = " C";
                    break;
                default:
                    topText = String.valueOf(carta.getNumero());
                    centerText = "  UNO  ";
                    bottomText = String.valueOf(carta.getNumero());
            }
        } else {

            topText = String.valueOf(carta.getNumero());
            centerText = " UNO ";
            bottomText = String.valueOf(carta.getNumero());
        }


        return String.format("""
            %s┌─────────┐%s
            %s│ %-2s      │%s
            %s│         │%s
            %s│ %-7s │%s
            %s│         │%s
            %s│      %2s │%s
            %s└─────────┘%s""",
                colorCode, RESET,
                colorCode, topText, RESET,
                colorCode, RESET,
                colorCode, centerText, RESET,
                colorCode, RESET,
                colorCode, bottomText, RESET,
                colorCode, RESET);
    }

    public static void mostrarCarta(Carta carta) {
        System.out.println(pintarCarta(carta));
    }

    public static void mostrarCartes(ArrayList<Carta> cartes) {
        int quantitat = cartes.size();
        String[][] cartesPintades = new String[quantitat][];

        for (int i = 0; i < quantitat; i++) {
            cartesPintades[i] = pintarCarta(cartes.get(i)).split("\n");
        }

        int altura = cartesPintades[0].length;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < quantitat; j++) {
                System.out.print(cartesPintades[j][i] + "  ");
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int j = 0; j < quantitat; j++) {
            System.out.printf("(%2d)         ", j);
        }
        System.out.println();
    }
}