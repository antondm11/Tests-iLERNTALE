package model;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

/**
 * Jugador - El Héroe del Escenario x4 (192px).
 * Calibrado para dar sensación de presencia y realce visual.
 */
public class Jugador {
    private String nombre;
    private int nivel;
    private int experiencia;
    private int salud;

    private int x, y;
    private int velocidad;
    private String direccion;

    public Rectangle solidArea;
    public boolean collisionOn = false;

    private int spriteCounter = 0;
    private int spriteNum = 1;

    private Map<TipoAtributo, Integer> atributos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.experiencia = 0;
        this.salud = 100;
        this.atributos = new HashMap<>();

        // CONFIGURACIÓN INICIAL (Escala x4 - 192px por tile)
        // Lo situamos en el suelo (Fila 1)
        this.x = 192;
        this.y = 192;
        this.velocidad = 6;
        this.direccion = "abajo";

        /**
         * HITBOX DE IMPACTO (192x192)
         * Centramos el área sólida en los pies (proporción 48x128 en el sprite)
         */
        solidArea = new Rectangle(48, 120, 96, 48);

        for (TipoAtributo tipo : TipoAtributo.values()) {
            this.atributos.put(tipo, 10);
        }
    }

    public void actualizarAnimacion() {
        spriteCounter++;
        if (spriteCounter > 12) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }
    }

    // --- GETTERS Y SETTERS ---
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public String getNombre() {
        return nombre;
    }
}
