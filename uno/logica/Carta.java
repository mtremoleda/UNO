package uno.logica;

import uno.Partida;

public abstract class Carta {
    protected int numero;
    protected Color color;
    protected String tipus;

    public enum Color {
        Groc, Vermell, Blau, Verd, Negre
    }

    public Carta(Color color, int numero, String tipus) {
        this.numero = numero;
        this.color = color;
        this.tipus = tipus;
    }

    public int getNumero() {
        return numero;
    }

    public Color getColor() {
        return color;
    }

    public String getTipus() {
        return tipus;
    }

    public boolean sonCartesCompatibles(Carta cartaSuperior) {
        return this.color == cartaSuperior.color || this.numero == cartaSuperior.numero ||
                this.color == Color.Negre || cartaSuperior.color == Color.Negre;
    }

    public abstract void aplicarEfecte(Partida partida);
}