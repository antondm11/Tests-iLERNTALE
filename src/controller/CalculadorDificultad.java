package controller;

/**
 * Controlador experto en el balanceo del juego.
 * Su única responsabilidad es determinar la dificultad de los retos.
 * Sigue el principio de Responsabilidad Única (SRP).
 */
public class CalculadorDificultad {

    /**
     * Calcula un número entero que representa la dificultad.
     * 
     * @param nivelEnemigo Nivel base del oponente.
     * @param esBoss       Si es un jefe, la dificultad aumenta significativamente.
     * @return Dificultad calculada.
     */
    public int calcular(int nivelEnemigo, boolean esBoss) {
        int base = nivelEnemigo * 2;
        if (esBoss) {
            return base + 10; // Los jefes son 10 puntos más difíciles que un enemigo normal de su nivel
        }
        return base;
    }
}
