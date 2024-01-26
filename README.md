# IS-ProyectoFinal-MarianitoUAMI
 Ingenieria de Software - Proyecto Final - Desarrollo de un videojuego 2D de plataforma usando SCRUM
1._ Acabamos las historias de usuario pendientes
2._ Cambiamos de repositorio
3._ Discución del product backlog, creación de 7 historias de usuario referentes al nivel 1
 y 2 del segundo sprint
Creación de las tareas para cada historia de usuario
Asignación de puntos para cada tarea correspondiente
Asignación de tareas según los puntos, (Solo de la 10 a la 12) porque la consideramos más prioritarias, pues
necesitábamos que ya estuvise listo: bloque vacío, bandera con su sonido, cheakpoint

Mauricio: Modificar la clase Bloques para incluir el sprite de un poste abanderado al final del nivel
Lo elaboré como si fuese una tubería, con dos rectángulos; uno pequeño para la pura bandera
y otro largo para el poste de la bandera. (Domingo)
HU-12 Act 2. Agregué una condición en la función de coliciónes para que
el juego pueda reaccionar a los bloques de la bandera y así se pueda implementar una acción (Lunes)  
Edgar: HU-10 Act-1 Lo creé utilizando un rectángulo al cuál le agregué el sprite de "espacio"(Domingo)
HU-10 Act-2 Agregué una condición en la función de coliciónes para que Marianito reaccion al "pisar" el espacio
y su variable booleana de "caída" cambie a true. y después marianito muera. (Lunes)
Pineda: HU-11 Crear el cheackpoint lo hice en el método de coliciones comparando el nivel en el que estás y la 
cantidad de vidas que tengo; si aún tengo vidas, marianito reaparece al inicio del nivel en el que murió, de
 lo contrario, el juego habrá terminado (Domingo)
HU-12 Act-2, creé un nuevo fondo en la clase Ventana para mostrar todas las estadísticas de marianito y dar la opción

Jueves, hacemos las pruebas finales 
 al usuario de seguir jugando (reintentar) o salir.(Lunes)
Agregar en la clase ventana distintos elementos para que el nivel tenga más obstáculos
 (Lo hice al final porque tuve que esperar al bloque "Espacio"), (Lunes).

Martes, HU-13 terminamos nuestras tareas del primer nivel y reasignamos las del segundo nivel:
Mauricio: Agregué el fondo del nivel 2 de forma similar al nivel 1 (con tres imágenes consecutivas en ciclo).
Utilizando el esqueleto de los bloques del nivel anterior, coloqué los nuevos sprites en la clase bloques
De la misma forma se agregó los sprites de goomba azul en la clase enemigos.
HU-14 Act-1 Agregué el sprite del enemigo "planta piraña" en la clase enemigos utilizando un rectángulo

Pineda: HU-14 Act-2En la clase ventana implemento el movimiento de la piraña utilizado dos boleanos, uno para la subida y otro para la bajada. Su altura máxima se define en la clase enemigos.
HU-15 Act1-cambiar las variables de cada enemigo en la clase enemigos. 

Edgar: HU-14 Act-3 En la clase Ventana modifico el método coliciones para la interacción entre marianito y la planta piraña
esta saldrá cada segundo de forma fija pero su duración de entrada-salida dependerá de la variable velocidad.
HU-15 act-2 modifico la clase ventana para incorporar más enemigos y bloques vacíos
HU-16 agrego el wav faltante en el main

 

