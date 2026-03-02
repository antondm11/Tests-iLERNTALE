package view;

import javax.swing.JFrame;

/**
 * MainFrame es la ventana principal (JFrame) del juego.
 * Actúa como el lienzo sobre el cual se colocan los diferentes paneles
 * (GamePanel, Menus, etc.).
 */
public class MainFrame extends JFrame {

    // El panel donde ocurre toda la acción del juego
    private GamePanel gamePanel;

    public MainFrame() {
        // Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana, se termina el proceso
        setResizable(false); // No permitimos redimensionar para evitar errores de renderizado
        setTitle("iLERNTALE"); // El título oficial del juego

        // Inicializamos e insertamos el panel de juego (GamePanel)
        gamePanel = new GamePanel();
        add(gamePanel);

        // Ajusta automáticamente el tamaño de la ventana al tamaño preferido de sus
        // componentes (GamePanel)
        pack();

        // Centramos la ventana en la pantalla del usuario
        setLocationRelativeTo(null);

        // Hacemos que la ventana sea visible
        setVisible(true);

        // Aseguramos que el panel tenga el foco para recibir eventos de teclado
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        // Una vez lista la ventana, arrancamos el motor del juego (el hilo)
        gamePanel.startGameThread();
    }
}
