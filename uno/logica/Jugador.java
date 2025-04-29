package uno.logica;

import uno.interficie.UI;

import java.util.ArrayList;



public class Jugador {
    private final String nom;
    private ArrayList<Carta> cartes;


    public Jugador (String n){
        nom = n;
        cartes = new ArrayList<>();
    }

    public String getNom(){
        return nom;
    }
    public ArrayList<Carta> getCartes(){
        return cartes;
    }
    public void tirarCarta(Carta carta, Pilo pilo) {
        if (cartes.contains(carta)){
            cartes.remove(carta);
            pilo.addCarta(carta);

            UI.mostrarCarta(carta);
        }
    }

    public void robarCarta(Mazo mazo){
        Carta cartaRobada = mazo.afagarCarta();
        cartes.add(cartaRobada);
    }

    public int nombreDeCartes(){
       return cartes.size();
    }



    public boolean potTirarCarta(Pilo pilo){
        for (int i = 0; i < cartes.size(); i++){
            Carta cartaJugador = cartes.get(i);
            Carta cartaSuperior = pilo.consultarCarta();

            if (Regles.sonCartesCompatibles(cartaJugador, cartaSuperior)){
                return true;
            }
        }
        return false;
    }

}
