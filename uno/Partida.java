package uno;

import uno.interficie.UI;
import uno.logica.*;
import java.util.Scanner;

public class Partida {
    private Scanner scanner = new Scanner(System.in);
    private OrdreJugador ordreJugadors = new OrdreJugador();
    private Mazo mazo = new Mazo();
    private Pilo pilo = new Pilo();
    private boolean partidaAcabada = false;
    private boolean sentitAntiHoriari = true; // true = horari, false = antihorari

    public void jugar() {
        preparar();

        while (!partidaAcabada) {
            torn();
        }
    }
    public OrdreJugador getOrdreJugadors() {
        return this.ordreJugadors;
    }
    public Mazo getMazo() {
        return this.mazo;
    }
    public void canviarSentit() {
        this.sentitAntiHoriari = !this.sentitAntiHoriari;
    }

    public void preparar() {
        System.out.println("Quants jugadors participen? (entre dos i deu jugadors)");
        int numJugadors = scanner.nextInt();
        while (numJugadors < 2 || numJugadors > 10) {
            System.out.println("Numero invalid. Introdueix un numero entre 2 i 10:");
            numJugadors = scanner.nextInt();
        }
        scanner.nextLine();


        for (int i = 1; i <= numJugadors; i++) {
            System.out.println("Nom del jugador " + i + ":");
            String nom = scanner.nextLine();
            ordreJugadors.crearJugador(nom);
        }

        ordreJugadors.barrejarOrdre();
        mazo.barrejar();


        repartirCartes();


        if (!ordreJugadors.jugadors.isEmpty()) {
            ordreJugadors.passarTorn();
        }

        Carta primeraCarta = mazo.afagarCarta();
        pilo.addCarta(primeraCarta);

        System.out.println("Comença el joc!");
        UI.mostrarCarta(primeraCarta);
    }

    public void repartirCartes() {
        for (int i = 0; i < 7; i++) {
            for (int x = 0; x < ordreJugadors.jugadors.size(); x++) {
                ordreJugadors.jugadors.get(x).robarCarta(mazo);
            }
        }
    }


    public void torn() {
        Jugador jugadorActual = ordreJugadors.getJugadorActiu();

        if (jugadorActual == null) {
            System.out.println("No hi ha jugador actiu");
            partidaAcabada = true;
            return;
        }

        System.out.println("Torn de: " + jugadorActual.getNom());
        System.out.println("Carta al pilo:");
        UI.mostrarCarta(pilo.consultarCarta());

        if (jugadorActual.potTirarCarta(pilo)) {
            UI.mostrarCartes(jugadorActual.getCartes());
            System.out.println("Tria una carta per tirar (numero) (robar carta = -1):");
            int eleccio = scanner.nextInt();

            if (eleccio == -1) {
                jugadorActual.robarCarta(mazo);
                passarTornSegonsSentit();
                return;
            }

            if (eleccio >= 0 && eleccio < jugadorActual.getCartes().size()) {
                Carta carta = jugadorActual.getCartes().get(eleccio);
                if (carta.sonCartesCompatibles(pilo.consultarCarta())) {
                    jugadorActual.tirarCarta(carta, pilo);
                    System.out.println(jugadorActual.getNom() + " ha tirat una carta.");

                    if (!carta.getTipus().equals("Numerica")) {
                        carta.aplicarEfecte(this);
                    } else {

                        passarTornSegonsSentit();
                    }

                    if (jugadorActual.nombreDeCartes() == 0) {
                        System.out.println(jugadorActual.getNom() + " ha guanyat la partida!");
                        partidaAcabada = true;
                        return;
                    }
                } else {
                    System.out.println("No pots tirar aquesta carta. Robant una...");
                    jugadorActual.robarCarta(mazo);
                    passarTornSegonsSentit();
                }
            } else {
                System.out.println("Opcio no valida.");
            }
        } else {
            System.out.println("No pots tirar cap carta. Robant una...");
            jugadorActual.robarCarta(mazo);
            passarTornSegonsSentit();
        }
    }


    private void passarTornSegonsSentit() {
        if (sentitAntiHoriari) {
            ordreJugadors.passarTorn();
        } else {
            ordreJugadors.passarTornInvers();
        }
    }

}
