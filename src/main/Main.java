package main;

import javax.swing.SwingUtilities;
import view.MainFrame;

/**
 * Clase de entrada (Entry Point) del juego.
 * Su única responsabilidad es arrancar la aplicación de forma segura.
 */
public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater asegura que toda la creación de la interfaz (GUI)
        // se realice en el hilo específico de Swing (Event Dispatch Thread o EDT).
        // Esto previene errores de concurrencia y bloqueos de la ventana.
        SwingUtilities.invokeLater(() -> {
            // Instanciamos el MainFrame para que la ventana se despliegue.
            new MainFrame();
        });
    }
}
