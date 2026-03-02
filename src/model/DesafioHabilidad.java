package model;

/**
 * Clase base (abstracta) para todos los mini-juegos de combate.
 * Define la estructura común que debe tener cualquier reto de habilidad.
 * Implementa el concepto de POLIMORFISMO: permite tratar diferentes juegos
 * (secuencias, puntería, etc.) como un "DesafioHabilidad" genérico.
 */
public abstract class DesafioHabilidad {
    protected String nombre;
    protected int dificultad;

    // El éxito del desafío ya no es SI/NO, sino una escala de precisión
    protected float precision; // 0.0 a 1.0 (cuántas teclas acertó)
    protected float tiempoRestante; // 0.0 a 1.0 (qué tan rápido fue)

    public DesafioHabilidad(String nombre, int dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.precision = 0;
        this.tiempoRestante = 0;
    }

    /**
     * Calcula una puntuación ponderada: 70% precisión y 30% rapidez.
     * 
     * @return Valor flotante que representa el desempeño global.
     */
    public float obtenerPuntuacionFinal() {
        return (precision * 0.7f) + (tiempoRestante * 0.3f);
    }

    /**
     * Método abstracto: Cada clase hija debe implementar su propia lógica de
     * inicio.
     */
    public abstract void iniciar();

    /**
     * Permite registrar el desempeño tras completar el mini-juego.
     */
    public void setResultados(float precision, float tiempoRestante) {
        this.precision = precision;
        this.tiempoRestante = tiempoRestante;
    }
}
