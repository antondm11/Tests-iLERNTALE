package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 * TileManager - El Arquitecto del Instituto con Atlas Refinado.
 * Extrae y dibuja los tiles del pasillo para un aspecto profesional.
 */
public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public final int maxWorldCol = 16;
    public final int maxWorldRow = 12;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.tile = new Tile[10]; // Definimos los tiles necesarios
        this.mapTileNum = new int[maxWorldCol][maxWorldRow];

        setupTerrain();
        loadMap("/resource/maps/map01.txt");
    }

    /**
     * Extrae los tiles del Atlas Refinado (48x48).
     */
    public void setupTerrain() {
        try {
            // Cargamos el atlas especificado por el usuario
            BufferedImage atlas = ImageIO.read(getClass().getResourceAsStream("/resource/map/tileset_atlas.png"));
            int size = 48;

            // FILA 0: SUELOS
            tile[0] = new Tile(); // Suelo Base
            tile[0].image = atlas.getSubimage(0, 0, size, size);
            tile[0].collision = false;

            // FILA 1: PAREDES Y MOBILIARIO
            tile[1] = new Tile(); // Pared Beige Ladrillo
            tile[1].image = atlas.getSubimage(0, size, size, size);
            tile[1].collision = true;

            tile[2] = new Tile(); // Taquillas Azules
            tile[2].image = atlas.getSubimage(size, size, size, size);
            tile[2].collision = true;

            tile[3] = new Tile(); // Ventana Instituto
            tile[3].image = atlas.getSubimage(size * 2, size, size, size);
            tile[3].collision = true;

            tile[4] = new Tile(); // Puerta Clase
            tile[4].image = atlas.getSubimage(size * 3, size, size, size);
            tile[4].collision = true;

            tile[5] = new Tile(); // Reloj de Pared
            tile[5].image = atlas.getSubimage(size * 4, size, size, size);
            tile[5].collision = true;

        } catch (Exception e) {
            System.err.println("Error al procesar el atlas refinado: " + e.getMessage());
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0, row = 0;
            while (col < maxWorldCol && row < maxWorldRow) {
                String line = br.readLine();
                if (line == null)
                    break;
                String numbers[] = line.split(" ");
                while (col < maxWorldCol) {
                    mapTileNum[col][row] = Integer.parseInt(numbers[col]);
                    col++;
                }
                if (col == maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int col = 0; col < maxWorldCol; col++) {
            for (int row = 0; row < maxWorldRow; row++) {
                int tileNum = mapTileNum[col][row];
                int x = col * gp.tileSize;
                int y = row * gp.tileSize;

                if (tileNum < tile.length && tile[tileNum] != null) {
                    // Pintamos siempre suelo base si es un objeto con posibles transparencias
                    if (tileNum != 0) {
                        g2.drawImage(tile[0].image, x, y, gp.tileSize + 1, gp.tileSize + 1, null);
                    }
                    g2.drawImage(tile[tileNum].image, x, y, gp.tileSize + 1, gp.tileSize + 1, null);
                }
            }
        }
    }
}
