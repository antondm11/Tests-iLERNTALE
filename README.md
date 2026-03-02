# 🎮 iLERNTALE - Videojuego Educativo (MVP Alpha)

Bienvenido al repositorio oficial de **iLERNTALE**, un videojuego desarrollado íntegramente por nuestro equipo para el 1er curso de DAW. Este proyecto combina mecánicas de RPG clásico con desafíos de habilidad para crear una experiencia de aprendizaje interactiva.

---

## 🚀 Nuestra Evolución (Hitos Cronológicos)

Como equipo, hemos avanzado siguiendo una hoja de ruta centrada en la calidad del código y la escalabilidad. Estos son los pasos que hemos dado hasta la fecha:

### 📅 Fase 1: Cimientos y Motor de Juego
*   **Arquitectura Base:** Establecimos la estructura del proyecto siguiendo el patrón **MVC (Modelo-Vista-Controlador)** para separar la lógica de negocio de la interfaz.
*   **Game Loop Profesional:** Desarrollamos un motor de renderizado en `GamePanel` basado en **Delta Time** a 60 FPS constantes.
*   **Ventana Principal:** Implementamos `MainFrame` configurado con doble buffer para evitar parpadeos gráficos.

### 📅 Fase 2: Lógica y Sistemas del Mundo
*   **Modelado del Héroe:** Creamos la clase `Jugador` con un sistema de experiencia (XP), niveles y gestión de salud dinámica.
*   **Tipado Fuerte:** Introdujimos el uso de `Enums` (`TipoAtributo`, `EstadoJuego`) para centralizar el comportamiento del juego.
*   **IA de Enemigos:** Definimos la estructura básica de los `Enemigos` y sus recompensas.

### 📅 Fase 3: Mecánicas de Desafío y Balanceo
*   **Abstracción de Retos:** Diseñamos `DesafioHabilidad` y su primera implementación: el **Desafío de Secuencia**.
*   **Módulo de Balanceo:** Implementamos el `CalculadorDificultad` para ajustar la dificultad del juego de forma independiente al código del reto.

### 📅 Fase 4: Integración Gráfica y Optimización
*   **ResourceManager (Nuestro Motor de Recursos):** Desarrollamos un gestor centralizado con caché (**Patrón Flyweight**) para optimizar el uso de memoria RAM.
*   **Optimización del Classpath:** Movimos la carpeta `resource` dentro de `src/` para asegurar la carga nativa de archivos.
*   **Sistema de Escalado:** Implementamos un sistema de **Tiles y Escala (x6)** para asegurar que los sprites se vean grandes, nítidos y con estética "pixel-art".

### 📅 Fase 5: Interacción y Locomoción
*   **Gestión de Input:** Creamos el `KeyHandler` para capturar eventos de teclado (Flechas y WASD).
*   **Movimiento en Tiempo Real:** Implementamos la física de movimiento del jugador, permitiendo explorar el mundo con fluidez.
*   **Animación Dinámica:** Desarrollamos un sistema de intercambio de frames automático que alterna los sprites de caminata según la dirección.

### 📅 Fase 6: Motor de Mapas y Colisiones
*   **TileManager:** Desarrollamos un motor de carga de mapas desde archivos de texto independientes (`map01.txt`). Esto permite diseñar niveles sin tocar una sola línea de código Java.
*   **Mapa de Prueba:** Creamos un mapa de prueba interactivo que incluye suelo, paredes, ventanas, árboles y objetos (PC, taquillas) extraídos de nuestra galería de assets.
*   **Sistema de Colisiones (CollisionChecker):** Implementamos un motor de colisiones físico. Ahora el jugador no puede atravesar paredes ni objetos sólidos, definiendo los límites reales del mundo de juego.

---

## 🛠️ Detalles Técnicos de Nuestra Arquitectura

### 🗺️ El Motor de Mapas (Tiles)
Usamos un sistema de cuadrícula (Grid System) donde cada casilla del mapa está representada por un número en un archivo `.txt`. El `TileManager` carga este mapa y lo dibuja en pantalla:
*   **0: Suelo** - Zona caminable.
*   **1: Pared** - Límite del mundo.
*   **2: Ventana** - Elemento sólido decorativo.
*   **3: Ordenador** - Objeto sólido de interacción futura.
*   **4: Árbol** - Obstáculo natural.
*   **5: Taquilla** - Decoración sólida.

### 🧱 El Motor de Colisiones (Hitbox)
Para un movimiento natural, el personaje no choca con "todo" su cuerpo. Hemos definido un **Solid Area (Hitbox)** situado únicamente en los pies del personaje. Esto permite efectos visuales de profundidad (que el personaje pueda "tapar" parcialmente un objeto si está debajo de él).
-   **Lógica de Choque:** El `CollisionChecker` calcula la posición futura del personaje antes de que se mueva realmente. Si detecta un tile sólido, bloquea el avance.

### ♾️ Game Loop y Rendimiento
-   **Delta Time:** Sincronización precisa para que el juego se mueva a la misma velocidad en cualquier hardware.
-   **Multi-threading:** El motor gráfico corre en un hilo independiente del sistema de eventos de Swing para evitar congelaciones.

---

## 📂 Estructura del Proyecto
*   [`src/main`](./src/main): Punto de entrada al juego.
*   [`src/model`](./src/model): Lógica de personajes, atributos y estados.
*   [`src/view`](./src/view): Interfaz gráfica, paneles, tiles y `ResourceManager`.
*   [`src/controller`](./src/controller): Lógica de control (`CalculadorDificultad`, `KeyHandler`, `CollisionChecker`).
*   [`src/resource/maps/`](./src/resource/maps): Configuración de niveles mediante ficheros de texto.

---

## 📈 Próximos Pasos
- [ ] Implementar un sistema de capas (Tiles de suelo vs Tiles de decoración elevada).
- [ ] Desarrollar efectos visuales al interactuar con objetos.
- [ ] Integrar el sistema de diálogos interactivos al acercarse a objetos específicos.

---
*Este proyecto es el resultado del esfuerzo conjunto de nuestro equipo de desarrollo. ¡Sigamos construyendo iLERNTALE!*
---
