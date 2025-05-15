package uno.logica;

import java.util.ArrayList;
import java.util.Collections;
public class OrdreJugador {
    public ArrayList <Jugador> jugadors = new ArrayList<>();
    private int tornActual = -1;

    public void passarTorn() {
        if (tornActual == -1) {
            tornActual = 0;
        } else {
            tornActual = (tornActual + 1) % jugadors.size();
        }
    }

    public Jugador getJugadorActiu() {
        return jugadors.get(tornActual);
    }


    public void crearJugador(String nom){
        jugadors.add(new Jugador(nom));
    }

    public void barrejarOrdre(){
        Collections.shuffle(jugadors);
    }

    public void invertirOrdre() {
        Collections.reverse(jugadors);
        tornActual = jugadors.size() - 1 - tornActual;
    }

    public void passarTornInvers() {
        if (tornActual == -1) {
            tornActual = jugadors.size() - 1;
        } else {
            tornActual = (tornActual - 1 + jugadors.size()) % jugadors.size();
        }
    }
}


