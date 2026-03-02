package model;

/**
 * Enumeración que controla los diferentes estados posibles de la aplicación.
 * Permite al MainFrame saber qué panel o lógica debe estar activa en cada
 * momento.
 */
public enum EstadoJuego {
    EXPLORACION, // Caminando por el mapa
    DIALOGO, // Hablando con un NPC
    BATALLA, // En medio de un mini-juego de combate
    MENU // En la pantalla de título o pausa
}
