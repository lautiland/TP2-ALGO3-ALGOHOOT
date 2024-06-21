package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class InteraccionesConJugadores {

    public static ArrayList<Jugador> pedirJugadores(int cantidadJugadores) {
        //iniciar interfaz gráfica para pedir nombres.
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < cantidadJugadores; i++){
            //pedir al usuario nombre.
            new Jugador("Player" + i);
            jugadores.add(new Jugador("Player" + i));
        }
        return jugadores;
    }

    public static int pedirCantidadDeJugadores() {
        //iniciar interfaz de consulta de cantidad
        //pedir al usuario
        return 3;
    }

    public static String pedirRutaArchivo() {
        //iniciar interfaz de ruta
        //pedir al usuario
        return "src/main/resources/preguntas.json";
    }
}
