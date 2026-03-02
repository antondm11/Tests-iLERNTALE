package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestor centralizado de recursos gráficos (Imágenes/Sprites).
 * Sigue el patrón Flyweight (caché) para evitar cargar la misma imagen varias
 * veces en RAM.
 * Proporciona métodos de conveniencia para acceder a los sprites por su lógica
 * de juego.
 */
public class ResourceManager {

    // Caché de imágenes para optimizar el rendimiento y la memoria
    private static final Map<String, BufferedImage> spriteCache = new HashMap<>();

    /**
     * Obtiene una imagen del sistema de archivos. Si ya ha sido cargada, la
     * devuelve desde la caché.
     * 
     * @param path Ruta relativa al classpath (ej:
     *             "/resource/player/migue/abajo1migue.png")
     * @return El objeto BufferedImage o null si hay un error.
     */
    public static BufferedImage getImage(String path) {
        if (spriteCache.containsKey(path)) {
            return spriteCache.get(path);
        }

        try (InputStream is = ResourceManager.class.getResourceAsStream(path)) {
            if (is == null) {
                System.err.println("RECURSO NO ENCONTRADO: " + path);
                return null;
            }
            BufferedImage img = ImageIO.read(is);
            spriteCache.put(path, img);
            return img;
        } catch (IOException e) {
            System.err.println("ERROR AL CARGAR LA IMAGEN: " + path);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Carga un sprite de jugador basado en sus parámetros de estado.
     * Sigue la convención de nombres: [direccion][frame][personaje].png
     */
    public static BufferedImage getPlayerSprite(String characterName, String direction, int frame) {
        String path = String.format("/resource/player/%s/%s%d%s.png",
                characterName.toLowerCase(),
                direction.toLowerCase(),
                frame,
                characterName.toLowerCase());
        return getImage(path);
    }

    /**
     * Carga un sprite de enemigo basado en la carpeta de tipo y el frame.
     */
    public static BufferedImage getEnemySprite(String enemyType, String direction, int frame) {
        // Asumiendo que los enemigos siguen una estructura similar
        String path = String.format("/resource/enemies/%s/%s%d%s.png",
                enemyType.toLowerCase(),
                direction.toLowerCase(),
                frame,
                enemyType.toLowerCase());
        return getImage(path);
    }

    /**
     * Limpia la caché si fuera necesario (cambio de nivel, etc.)
     */
    public static void clearCache() {
        spriteCache.clear();
    }
}
