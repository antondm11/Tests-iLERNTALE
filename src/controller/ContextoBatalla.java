package controller;

import model.*;

/**
 * Controlador que gestiona el flujo de un encuentro de combate.
 * Se encarga de conectar al Jugador con el Enemigo y procesar
 * las consecuencias del DesafioHabilidad.
 */
public class ContextoBatalla {
    private Jugador jugador;
    private Enemigo enemigo;

    /**
     * @param jugador Instancia del protagonista.
     * @param enemigo Instancia del oponente actual.
     */
    public ContextoBatalla(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    /**
     * Inicia la lógica de encuentro.
     * Comprueba atributos del jugador y ejecuta ataques iniciales.
     */
    public void iniciarBatalla() {
        System.out.println("¡Batalla iniciada entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");

        // Ejemplo de cómo los atributos del modelo afectan a la lógica del controlador
        if (jugador.getAtributo(TipoAtributo.CAPACIDAD_DECISION) > 10) {
            System.out.println("El jugador tiene la iniciativa por su Capacidad de Decisión.");
        }

        // Simulación: El enemigo ataca primero usando su estadística de daño base
        jugador.recibirDaño(enemigo.getDañoBase());
    }

    /**
     * Evalúa el desempeño del jugador en el mini-juego y aplica recompensas o
     * castigos.
     * 
     * @param desafio El mini-juego ya completado.
     */
    public void procesarResultado(DesafioHabilidad desafio) {
        float puntuacion = desafio.obtenerPuntuacionFinal();
        System.out.println("Resultado del desafío: " + puntuacion);

        // Umbral de victoria (50% de desempeño)
        if (puntuacion > 0.5f) {
            System.out.println("¡Victoria! El enemigo ha sido derrotado.");

            // Recompensa en experiencia
            jugador.añadirExperiencia(enemigo.getRecompensaExperiencia());

            // Recompensa en atributos: Mejoramos la EMPATÍA tras el combate
            jugador.mejorarAtributo(TipoAtributo.EMPATIA, 1);
        } else {
            System.out.println("Derrota. El jugador no superó el desafío.");
        }
    }
}
