package model;

import controller.CalculadorDificultad;

/**
 * Representa a los adversarios en el juego.
 * Cada enemigo puede generar un desafío de habilidad basado en su nivel.
 */
public class Enemigo {
    private String nombre;
    private int nivel;
    private int dañoBase;
    private int recompensaExperiencia;
    private boolean esBoss;

    public Enemigo(String nombre, int nivel, int dañoBase, int experiencia, boolean esBoss) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.dañoBase = dañoBase;
        this.recompensaExperiencia = experiencia;
        this.esBoss = esBoss;
    }

    /**
     * Crea un reto de combate adaptado a las estadísticas del enemigo.
     * Utiliza el controlador CalculadorDificultad para equilibrar el juego.
     * 
     * @return Un objeto DesafioHabilidad (polimorfismo).
     */
    public DesafioHabilidad configurarReto() {
        // Delegamos el cálculo de la dificultad a una clase experta (SRP)
        CalculadorDificultad calculador = new CalculadorDificultad();
        int dificultad = calculador.calcular(this.nivel, this.esBoss);

        // Devolvemos el tipo de desafío por defecto para este MVP: una secuencia de
        // teclas
        return new DesafioSecuencia("Reto de " + nombre, dificultad);
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public int getDañoBase() {
        return dañoBase;
    }

    public int getRecompensaExperiencia() {
        return recompensaExperiencia;
    }
}
