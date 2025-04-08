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
    public void addCarta(Carta carta) {
       cartes.add(carta);
    }


    public void tirarCarta(Carta carta, Pilo pilo) {
        if (cartes.contains(carta)){
            cartes.remove(carta);
            pilo.addCarta(carta);
            System.out.printf(nom + "ha tirat la carta");
            UI.mostrarCarta(carta);
        } else {
            System.out.println("no te aquesta carta");
        }
    }
}
