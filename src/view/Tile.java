package view;

import java.awt.image.BufferedImage;

/**
 * Representa una baldosa (tile) individual del mapa.
 * Almacena la imagen y si tiene colisin activa.
 */
public class Tile {
    public BufferedImage image;
    public boolean collision = false;
}
