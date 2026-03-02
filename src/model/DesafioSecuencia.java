package model;

/**
 * Especialización de DesafioHabilidad para retos de secuencia de teclas.
 * Es un ejemplo concreto de CÓMO se implementa un desafío en este RPG.
 */
public class DesafioSecuencia extends DesafioHabilidad {

    // La combinación de teclas que el jugador debe introducir
    private String secuenciaObjetivo;

    public DesafioSecuencia(String nombre, int dificultad) {
        // Llamada al constructor de la clase padre (DesafioHabilidad)
        super(nombre, dificultad);
        this.secuenciaObjetivo = "WASD"; // Secuencia fija para la demo del MVP
    }

    /**
     * Implementación concreta del método iniciar.
     * Muestra la secuencia objetivo por consola.
     */
    @Override
    public void iniciar() {
        System.out.println(">>> DESAFÍO DE SECUENCIA <<<");
        System.out.println("Nombre: " + nombre);
        System.out.println("Objetivo: Introduce " + secuenciaObjetivo);
    }
}
