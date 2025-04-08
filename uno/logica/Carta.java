package uno.logica;

public class Carta {
    public int numero;
    public Color color;

    public enum Color {
        Groc, Vermell, Blau, Verd
    }

    public Carta(Color color, int numero){
        this.numero = numero;
        this.color = color;
    }

    public int getNumero(){
        return numero;
    }

    public Color getColor(){
        return color;
    }
}