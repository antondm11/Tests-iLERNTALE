package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import controller.KeyHandler;
import controller.CollisionChecker;
import model.Jugador;

/**
 * GamePanel - Motor iLERNTALE v1.0 (Escala x6).
 * Optimizado para eliminar cualquier espacio entre tiles y dar fluidez total.
 */
public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    // ESCALA DE ORO (x4): 192px reales.
    // Equilibrio perfecto: Migue se ve grande y el pasillo tiene forma.
    public final int originalTileSize = 48;
    public final int scale = 4;
    public final int tileSize = originalTileSize * scale;

    private Thread gameThread;
    private boolean running;
    private final int FPS = 60;

    public KeyHandler keyH = new KeyHandler();
    public TileManager tileM = new TileManager(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Jugador jugador = new Jugador("Migue");

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        running = true;
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null && running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed)
                jugador.setDireccion("arriba");
            else if (keyH.downPressed)
                jugador.setDireccion("abajo");
            else if (keyH.leftPressed)
                jugador.setDireccion("izquierda");
            else if (keyH.rightPressed)
                jugador.setDireccion("derecha");

            jugador.collisionOn = false;
            cChecker.checkTile(jugador);

            if (!jugador.collisionOn) {
                switch (jugador.getDireccion()) {
                    case "arriba":
                        jugador.setY(jugador.getY() - jugador.getVelocidad());
                        break;
                    case "abajo":
                        jugador.setY(jugador.getY() + jugador.getVelocidad());
                        break;
                    case "izquierda":
                        jugador.setX(jugador.getX() - jugador.getVelocidad());
                        break;
                    case "derecha":
                        jugador.setX(jugador.getX() + jugador.getVelocidad());
                        break;
                }
            }
            jugador.actualizarAnimacion();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // --- SISTEMA DE CONTINUIDAD ABSOLUTA (PIXEL PERFECT) ---
        // Desactivamos todo el suavizado para que las baldosas choquen entre sí sin
        // huecos
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        // Capa 0: El Mapa (Paredes y Suelos se pegan aquí)
        tileM.draw(g2);

        // Capa 1: El Jugador
        BufferedImage image = ResourceManager.getPlayerSprite(
                jugador.getNombre(),
                jugador.getDireccion(),
                jugador.getSpriteNum());

        if (image != null) {
            g2.drawImage(image, jugador.getX(), jugador.getY(), tileSize, tileSize, null);
        }

        g2.dispose();
    }
}
