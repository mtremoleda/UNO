package uno;

public class Carta {
    public int numero;
    public colors color;

    public enum colors{
        Groc, Vermell, Blau, Verd
    }

    public Carta(colors color, int numero){
        this.numero = numero;
        this.color = color;
    }

    public int getNumero(){
        return numero;
    }

    public colors getColor(){
        return color;
    }
}