import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Menu extends JPanel {

    // Tengo que revisar si esta estructura es

    // Este es el Menú, que tendrá los botones de opciones y el fondo del juego

    // Atributos (que son los botones)
    JButton botonNuevaPartida, botonCargarPartida, botonOpciones, botonCreditos, botonSalir;

    // Constructor
    public Menu() {

        // No asignar distribución por defecto
        setLayout(null);
        // Dejar el fondo vacío por defecto
        setBackground(null);
        // Botones
        // Incializar aquí los botones como objetos con su texto y estilo
        // Botón de iniciar Nueva Partida
        botonNuevaPartida = new JButton("Nueva Partida");
        botonNuevaPartida.setBounds(100, 60, 300, 50);
        // Probar el actionListener (iría en Controlador)
        botonNuevaPartida.setOpaque(false);
        botonNuevaPartida.setForeground(Color.WHITE);
        botonNuevaPartida.setBorder(new LineBorder(Color.RED));

        // Botón de Cargar Partida
        botonCargarPartida = new JButton("Cargar Partida");
        botonCargarPartida.setBounds(100, 160, 300, 50);
        botonCargarPartida.setOpaque(false);
        // Color del fondo
        botonCargarPartida.setForeground(Color.WHITE);
        // Probar un contorno
        botonCargarPartida.setBorder(new LineBorder(Color.RED));

        // Botón de Opciones
        botonOpciones = new JButton("Opciones");
        botonOpciones.setBounds(100, 260, 300, 50);
        botonOpciones.setOpaque(false);
        botonOpciones.setForeground(Color.WHITE);
        botonOpciones.setBorder(new LineBorder(Color.RED));

        // Botón de Créditos
        botonCreditos = new JButton("Creditos");
        botonCreditos.setBounds(100, 360, 300, 50);
        botonCreditos.setOpaque(false);
        botonCreditos.setForeground(Color.WHITE);
        botonCreditos.setBorder(new LineBorder(Color.RED));

        // Botón de Salir
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(100, 460, 300, 50);
        botonSalir.setOpaque(false);
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setBorder(new LineBorder(Color.RED));

        JPanel panel = new JPanel();

        // Añadir Botones
        panel.add(botonNuevaPartida);
        panel.add(botonCargarPartida);
        panel.add(botonOpciones);
        panel.add(botonCreditos);
        panel.add(botonSalir);

    }

    // Métodos para Asignar la imagen de fondo del menú
    // Esto habría que revisarlo si queremos que vaya cambiando entre las 3
    // variantes
    @Override
    public void paint(Graphics g) {
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/menu1.jpg"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }

    // Finalmente, hacer visible todo el panel menú en el Frame con
    // setVisible(true);

    /*
     * Luego habrá que ir haciendolo invisible a la vez que se hagan visibles
     * las pantallas a las que lleve (juego, opciones, créditos...)
     */

}
