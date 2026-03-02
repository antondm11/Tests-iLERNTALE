# Plan de Sprint: RPG Java Swing - MVP Alpha

**Periodo:** 28 de febrero de 2026 - 14 de marzo de 2026 (14 días)
**Equipo:** 3 personas (Persona A, Persona B, Persona C)
**Horario Laboral:** Lunes a Viernes (17:00 - 23:00) | Fines de Semana: Jornada intensiva/Libre disposición.

---

## 📅 Semana 1: Cimientos y Mundo Explorable (28 Feb - 6 Mar)
*Objetivo: Tener un personaje que se mueva por un entorno, colisione con objetos y pueda iniciar transiciones de estado.*

### 🛠️ Día 1 [FASE 1]: Estructura Base y Ventanas (28 Feb - Sábado)
*   **Persona A (Arquitectura):** Implementar el `GameLoop` principal usando un `System.nanoTime()` y manejo de hilos.
*   **Persona B (UI):** Crear la ventana principal `MainFrame` (JFrame) y el contenedor principal `GamePanel` (JPanel).
*   **Persona C (Model):** Refinar las clases `Jugador` y `Enemigo` con los métodos faltantes según `ARCHITECTURE_MVP.md`.

### 🛠️ Día 2 [FASE 2]: Movimiento y Física Simple (1 Mar - Domingo)
*   **Persona A (Control):** Implementar el sistema de entrada `KeyHandler` para capturar WASD.
*   **Persona B (Graphics):** Dibujar un sprite temporal para el Jugador y el fondo.
*   **Persona C (Lógica):** Implementar límites de pantalla y detección de bordes para el movimiento.

### 🛠️ Día 3 [FASE 3]: Mapa y Objetos (2 Mar - Lunes)
*   **Persona A (Backend):** Crear sistema de gestión de entidades (`ArrayList<Entidad>`).
*   **Persona B (Assets):** Implementar la carga de imágenes reales para el pasillo y objetos.
*   **Persona C (Mecánicas):** Clase `Item` y sistema de colisión círculo/rectángulo simple para recoger objetos.

### 🛠️ Día 4 [FASE 4]: Enemigos (3 Mar - Martes)
*   **Persona A (Estado):** Implementar el cambio de estado en `EstadoJuego` (Exploración -> Diálogo).
*   **Persona B (UI):** Crear un `DialoguePanel` superpuesto para mostrar mensajes de texto.
*   **Persona C (Contenido):** Configurar triggers de combate al colisionar con enemigos en el mapa.

### 🛠️ Día 5: Interfaz de Usuario (HUD) (4 Mar - Miércoles)
*(Complemento a Fase 3 y 4)*
*   **Persona A (Control):** Sincronizar stats del Jugador con la UI.
*   **Persona B (UI):** Crear el HUD (barra de vida, nivel y experiencia) usando `Graphics2D`.
*   **Persona C (Mecánicas):** Lógica de aumento de estadísticas al recoger items específicos.

### 🛠️ Día 6 [FASE 5]: Base del Sistema de Combate (5 Mar - Jueves)
*   **Persona A (Lógica):** Implementar `ContextoBatalla` para gestionar turnos y flujo de datos.
*   **Persona B (UI):** Crear `CombatPanel` con una estética diferenciada (Gris/Oscuro).
*   **Persona C (Mecánicas):** Integrar `CalculadorDificultad` para escalar el daño del enemigo.

### 🛠️ Día 7 [FASE 5+]: Desafío de Habilidad (Mini-juego) (6 Mar - Viernes)
*   **Persona A (Lógica):** Lógica de `DesafioSecuencia` (verificar teclas en orden).
*   **Persona B (UI):** Visualización de la secuencia de teclas en pantalla durante el combate.
*   **Persona C (Mecánicas):** Temporizador para el desafío y cálculo de precisión.

---

## 📅 Semana 2: Combate Avanzado, Boss y Pulido (7 Mar - 14 Mar)
*Objetivo: Finalizar el gameplay loop, añadir el jefe final y asegurar la jugabilidad sin errores.*

### 🛠️ Día 8 [PULIDO]: Pulido del Combate (7 Mar - Sábado)
*   **Persona A (Integración):** Procesar resultados del mini-juego y aplicar daño al Jugador/Enemigo.
*   **Persona B (FX):** Añadir efectos visuales simples (parpadeo al recibir daño, temblor de pantalla).
*   **Persona C (Contenido):** Balancear las dificultades de los enemigos comunes.

### 🛠️ Día 9 [MECÁNICAS]: Sistema de Recompensas (8 Mar - Domingo)
*   **Persona A (Backend):** Lógica de subida de nivel y asignación de puntos de atributo.
*   **Persona B (UI):** Pantalla de "Victoria" con el resumen de experiencia ganada.
*   **Persona C (Mecánicas):** Implementación de diferentes tipos de enemigos con ataques variados.

### 🛠️ Día 10 [FASE 6]: El Jefe Final (The Boss) (9 Mar - Lunes)
*   **Persona A (Lógica):** Crear clase `Boss` con fases de combate (cambio de patrón al 50% vida).
*   **Persona B (UI):** Barra de vida especial para el Boss en la parte superior.
*   **Persona C (Contenido):** Diseñar una `DesafioSecuencia` única y más difícil para el Boss.

### 🛠️ Día 11 [EXTRAS]: Navegación y Menús (10 Mar - Martes)
*   **Persona A (Estado):** Menú de Inicio (Start, Exit) y Menú de Pausa.
*   **Persona B (UI):** Estética de botones consistente y selección con teclado.
*   **Persona C (Mecánicas):** Persistencia simple (opcional: guardar nombre del jugador).

### 🛠️ Día 12 [FASE 7]: Pantallas Finales y Estados (11 Mar - Miércoles)
*   **Persona A (Estado):** Implementar `ENDING` y `GAME_OVER`.
*   **Persona B (UI):** Pantalla de créditos y Game Over con opción de reiniciar.
*   **Persona C (Control):** Reset de variables de juego para nueva partida.

### 🛠️ Día 13 [QA]: Pruebas y Correcciones (12 Mar - Jueves)
*   **TODO EL EQUIPO:** Playtesting intensivo buscando bugs de colisión o lógica.
*   **Persona A:** Refactorización de código para mejorar rendimiento.
*   **Persona B:** Ajustes finos de UI (fuentes, alineación).
*   **Persona C:** Ajuste final de dificultad (Game Balance).

### 🛠️ Día 14 [DOCS]: Documentación y Entrega (13 Mar - Viernes)
*   **TODO EL EQUIPO:** Actualizar `README.md` y generar Javadoc.
*   **Persona A:** Asegurar que el JAR ejecutable funcione correctamente.
*   **Persona C:** Preparar la presentación/demo del proyecto.

### 🛠️ Día Final: Cierre (14 Mar - Sábado)
*   **ENTREGA FINAL DEL PROYECTO.**

---

## 📋 Tareas para GitHub Projects (Backlog Directo)

Estas tareas están diseñadas para ser copiadas y pegadas directamente en sus issues de GitHub:

1. **[FASE 1]** Inicialización de proyecto con Git y carpetas `src/model`, `src/view`, `src/controller`.
2. **[FASE 1]** Creación de `MainFrame` (JFrame) con configuración de centrado y cierre.
3. **[FASE 1]** Clase `Thread` para el Game Loop con cálculo de DeltaTime.
4. **[FASE 2]** Listener de teclado integrado en `GamePanel`.
5. **[FASE 2]** Renderizado de sprite base y animación simple de movimiento.
6. **[FASE 3]** Implementación de clase `Tile` o `Background` con scroll.
7. **[FASE 3]** Algoritmo de AABB (Axis-Aligned Bounding Box) para items.
8. **[FASE 5]** Interfaz visual para `DesafioSecuencia` con barras de progreso.
9. **[HUD]** Renderizado de HUD mediante `Graphics.drawString` y `fillRect`.
10. **[FASE 6]** Lógica de estados del Boss (Idle, Attack, Phase Change).
11. **[FASE 7]** Pantalla de Game Over y lógica de reinicio de estado.
12. **[DOCS]** Manual de usuario en `README.md` con controles.
