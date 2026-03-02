package controller;

import model.Jugador;
import view.GamePanel;

/**
 * CollisionChecker - El "Árbitro" del Juego.
 * Su único objetivo en la vida es detener al jugador antes de que atraviese una
 * pared.
 */
public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * El "Detector de Próximos Pasos".
     * Mira hacia dónde se mueve el jugador y detecta si hay un obstáculo en esa
     * dirección.
     */
    public void checkTile(Jugador jugador) {

        // --- PASO 1: Calcular los bordes físicos del jugador ---
        // El jugador es una imagen, pero su zona "sólida" (los pies) está definida en
        // el Rectangle 'solidArea'
        int playerLeftWorldX = jugador.getX() + jugador.solidArea.x;
        int playerRightWorldX = jugador.getX() + jugador.solidArea.x + jugador.solidArea.width;
        int playerTopWorldY = jugador.getY() + jugador.solidArea.y;
        int playerBottomWorldY = jugador.getY() + jugador.solidArea.y + jugador.solidArea.height;

        // --- PASO 2: Identificar en qué columna y fila del mapa están esos bordes ---
        // Dividimos la coordenada (ej: 300px) entre el tamaño del tile (ej: 48px) para
        // saber que está en la casilla 6 del mapa
        int playerLeftCol = playerLeftWorldX / gp.tileSize;
        int playerRightCol = playerRightWorldX / gp.tileSize;
        int playerTopRow = playerTopWorldY / gp.tileSize;
        int playerBottomRow = playerBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        // --- PASO 3: Detectar el movimiento en la próxima actualización ---
        switch (jugador.getDireccion()) {
            case "arriba":
                playerTopRow = (playerTopWorldY - jugador.getVelocidad()) / gp.tileSize;
                if (playerTopRow >= 0) {
                    tileNum1 = gp.tileM.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = gp.tileM.mapTileNum[playerRightCol][playerTopRow];
                    // ¿Es sólido alguno de los tiles de arriba?
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        jugador.collisionOn = true;
                    }
                }
                break;
            case "abajo":
                playerBottomRow = (playerBottomWorldY + jugador.getVelocidad()) / gp.tileSize;
                if (playerBottomRow < gp.tileM.maxWorldRow) {
                    tileNum1 = gp.tileM.mapTileNum[playerLeftCol][playerBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[playerRightCol][playerBottomRow];
                    // ¿Es sólido alguno de los tiles de abajo?
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        jugador.collisionOn = true;
                    }
                }
                break;
            case "izquierda":
                playerLeftCol = (playerLeftWorldX - jugador.getVelocidad()) / gp.tileSize;
                if (playerLeftCol >= 0) {
                    tileNum1 = gp.tileM.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = gp.tileM.mapTileNum[playerLeftCol][playerBottomRow];
                    // ¿Es sólido alguno de los tiles de la izquierda?
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        jugador.collisionOn = true;
                    }
                }
                break;
            case "derecha":
                playerRightCol = (playerRightWorldX + jugador.getVelocidad()) / gp.tileSize;
                if (playerRightCol < gp.tileM.maxWorldCol) {
                    tileNum1 = gp.tileM.mapTileNum[playerRightCol][playerTopRow];
                    tileNum2 = gp.tileM.mapTileNum[playerRightCol][playerBottomRow];
                    // ¿Es sólido alguno de los tiles de la derecha?
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        jugador.collisionOn = true;
                    }
                }
                break;
        }
    }
}
