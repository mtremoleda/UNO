package UNO;

public class Jugador {
    String nom;
    public Carta[] cartes;

    public Jugador (String nom, Carta[] cartes){
        this.nom = nom;
        this.cartes = cartes;
    }

    public String getNom(){
        return nom;
    }

    public Carta[] getCartes(){
        return cartes;
    }

}
