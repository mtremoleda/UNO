package UNO;

public class Carta {
    public int numero;
    public enum color{
        Groc, Vermell, Blau, Verd
    }

    public Carta(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }
}