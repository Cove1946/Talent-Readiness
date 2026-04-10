# Refuerzo – Análisis de Requerimientos
## Escenario 1: Plataforma de Entrenadores Pokémon

Una empresa de videojuegos desea desarrollar una aplicación web que permita a los usuarios registrarse como entrenadores 
y gestionar sus Pokémon para participar en combates contra otros jugadores en línea.

El sistema debe permitir la creación de equipos, la interacción entre jugadores y la visualización del progreso de cada 
entrenador dentro de una liga competitiva.

Actualmente, el cliente ha manifestado preocupaciones sobre:
- La experiencia del usuario durante los combates
- La capacidad de soportar múltiples usuarios conectados simultáneamente
- La seguridad de las cuentas
- La claridad en el historial de batallas

Adicionalmente, el cliente menciona que en el futuro le gustaría incluir nuevas funcionalidades como torneos, 
recompensas y modos de juego adicionales, aunque estas aún no están completamente definidas.

Es importante tener en cuenta que el cliente no ha entregado documentación formal, únicamente estas necesidades generales.

## 1. Identificación de Requerimientos

A partir del enunciado se extraen los siguientes requerimientos, tanto explícitos como implícitos

- No se limiten a lo evidente
- Consideren supuestos razonables (ej: autenticación, persistencia, etc.)

### Requerimientos Explícitos

| ID    | Requerimiento identificado |
|-------|---------------------------|
| RE-01 | Los usuarios deben poder registrarse como entrenadores en la plataforma. |
| RE-02 | El sistema debe permitir gestionar Pokémon propios (agregar, ver, organizar). |
| RE-03 | El sistema debe permitir crear equipos de Pokémon. |
| RE-04 | El sistema debe soportar combates entre jugadores en línea. |
| RE-05 | El sistema debe permitir la interacción entre jugadores. |
| RE-06 | El sistema debe mostrar el progreso de cada entrenador dentro de una liga competitiva. |
| RE-07 | El sistema debe garantizar una buena experiencia de usuario durante los combates. |
| RE-08 | El sistema debe soportar múltiples usuarios conectados simultáneamente. |
| RE-09 | El sistema debe garantizar la seguridad de las cuentas de usuario. |
| RE-10 | El sistema debe proporcionar un historial de batallas claro y accesible. |
| RE-11 | El sistema debe estar diseñado para escalar e incorporar torneos en el futuro. |
| RE-12 | El sistema debe estar diseñado para incorporar recompensas en el futuro. |
| RE-13 | El sistema debe estar diseñado para incorporar modos de juego adicionales en el futuro. |

---

### Requerimientos Implícitos

| ID    | Requerimiento identificado | Justificación del supuesto |
|-------|---------------------------|---------------------------|
| RI-01 | El sistema debe autenticar a los usuarios mediante credenciales (usuario/contraseña u OAuth). | Todo sistema con cuentas requiere autenticación. |
| RI-02 | El sistema debe persistir los datos de usuarios, Pokémon, equipos y batallas en una base de datos. | Sin persistencia no hay progreso ni historial. |
| RI-03 | El sistema debe permitir la recuperación de contraseña. | Requerimiento de seguridad estándar. |
| RI-04 | El sistema debe validar los datos ingresados en formularios (registro, equipos, etc.). | Evita datos corruptos e inconsistencias. |
| RI-05 | El sistema debe contar con roles de usuario (jugador, administrador al menos). | Se necesita gestionar la liga y usuarios desde un panel de control. |
| RI-06 | El sistema debe permitir buscar o encontrar a otros jugadores para combatir. | Sin este mecanismo no hay combates en línea posibles. |
| RI-07 | El sistema debe sincronizar el estado del combate en tiempo real entre ambos jugadores. | Un combate online requiere comunicación bidireccional en tiempo real  |
| RI-08 | El sistema debe manejar desconexiones durante un combate sin corromper el estado de la partida. | Garantiza integridad ante fallos de red. |
| RI-09 | El sistema debe mostrar estadísticas básicas de cada Pokémon (nivel, tipo, movimientos, etc.). | Necesario para que el jugador tome decisiones en combate. |
| RI-10 | El sistema debe tener una interfaz responsiva o adaptada al dispositivo del usuario. | Aplicación web moderna debe funcionar en distintos dispositivos. |
| RI-11 | El sistema debe registrar logs de actividad para auditoría y soporte. | Buena práctica de seguridad y mantenimiento. |
| RI-12 | El sistema debe cumplir con políticas de protección de datos personales. | Obligatorio al manejar cuentas y datos de usuarios. |
| RI-13 | El sistema debe contar con un mecanismo de matchmaking o emparejamiento entre jugadores. | Sin esto, los combates no se pueden organizar de forma justa o eficiente. |
| RI-14 | El sistema debe mostrar el ranking o clasificación de entrenadores dentro de la liga. | El enunciado menciona "liga competitiva", lo que implica una tabla de posiciones. |
| RI-15 | El sistema debe notificar a los usuarios sobre eventos relevantes (retos, resultados, etc.). | Mejora la experiencia y retención del jugador. |

---

## 2. Clasificación
Clasifiquen cada requerimiento como:

- Funcional
- No funcional

Justifiquen brevemente cada clasificación.

---

### Requerimientos Explícitos

| ID    | Requerimiento | Tipo | Justificación |
|-------|--------------|------|---------------|
| RE-01 | Los usuarios deben poder registrarse como entrenadores. | RF | Define una acción concreta que el sistema debe ejecutar. |
| RE-02 | El sistema debe permitir gestionar Pokémon propios. | RF | Describe operaciones sobre datos (agregar, ver, organizar). |
| RE-03 | El sistema debe permitir crear equipos de Pokémon. | RF | Define una funcionalidad específica de gestión. |
| RE-04 | El sistema debe soportar combates entre jugadores en línea. | RF | Es el flujo principal de negocio de la aplicación. |
| RE-05 | El sistema debe permitir la interacción entre jugadores. | RF | Implica acciones concretas como retarse, chatear o enviar solicitudes. |
| RE-06 | El sistema debe mostrar el progreso del entrenador en la liga. | RF | Corresponde a la visualización de datos procesados por el sistema. |
| RE-07 | El sistema debe garantizar una buena experiencia durante los combates. | RNF | Hace referencia a usabilidad y fluidez, no a una función específica. |
| RE-08 | El sistema debe soportar múltiples usuarios simultáneos. | RNF | Define una capacidad de rendimiento y escalabilidad del sistema. |
| RE-09 | El sistema debe garantizar la seguridad de las cuentas. | RNF | Atributo de calidad relacionado con seguridad y protección de datos. |
| RE-10 | El sistema debe proporcionar un historial de batallas claro. | RF | Define la visualización y acceso a datos históricos específicos. |
| RE-11 | El sistema debe estar diseñado para escalar e incorporar torneos. | RNF | Hace referencia a extensibilidad y arquitectura, no a una función inmediata. |
| RE-12 | El sistema debe estar diseñado para incorporar recompensas. | RNF | Atributo de extensibilidad futura, no una funcionalidad activa aún. |
| RE-13 | El sistema debe estar diseñado para incorporar modos de juego adicionales. | RNF | Corresponde a escalabilidad y diseño modular del sistema. |

---

### Requerimientos Implícitos

| ID    | Requerimiento | Tipo | Justificación |
|-------|--------------|------|---------------|
| RI-01 | El sistema debe autenticar a los usuarios. | RF | Es una función concreta que el sistema debe ejecutar en cada sesión. |
| RI-02 | El sistema debe persistir los datos en una base de datos. | RNF | Define una característica de infraestructura y confiabilidad del sistema. |
| RI-03 | El sistema debe permitir la recuperación de contraseña. | RF | Es un flujo funcional específico con pasos definidos. |
| RI-04 | El sistema debe validar los datos ingresados en formularios. | RF | Implica una lógica de negocio aplicada sobre entradas del usuario. |
| RI-05 | El sistema debe contar con roles de usuario. | RF | Define distintos comportamientos y permisos según el tipo de usuario. |
| RI-06 | El sistema debe permitir buscar otros jugadores para combatir. | RF | Es una funcionalidad activa que el usuario ejecuta dentro del sistema. |
| RI-07 | El sistema debe sincronizar el combate en tiempo real entre jugadores. | RNF | Define un atributo de rendimiento y comunicación, no una función aislada. |
| RI-08 | El sistema debe manejar desconexiones sin corromper el estado del combate. | RNF | Es un atributo de confiabilidad y tolerancia a fallos. |
| RI-09 | El sistema debe mostrar estadísticas básicas de cada Pokémon. | RF | Define la visualización de datos específicos dentro de la interfaz. |
| RI-10 | El sistema debe tener una interfaz responsiva. | RNF | Atributo de usabilidad y compatibilidad con distintos dispositivos. |
| RI-11 | El sistema debe registrar logs de actividad. | RNF | Corresponde a auditabilidad y mantenibilidad del sistema. |
| RI-12 | El sistema debe cumplir con políticas de protección de datos. | RNF | Es un atributo de cumplimiento normativo (compliance), no una función. |
| RI-13 | El sistema debe contar con un mecanismo de matchmaking. | RF | Define un proceso funcional con lógica de negocio propia. |
| RI-14 | El sistema debe mostrar el ranking de entrenadores en la liga. | RF | Es una visualización de datos concretos generados por el sistema. |
| RI-15 | El sistema debe notificar a los usuarios sobre eventos relevantes. | RF | Define un flujo de comunicación activo del sistema hacia el usuario. |

## 3. Redacción Correcta de Requerimientos

Cada requerimiento se reformula en formato estándar ("El sistema debe..."),
eliminando ambigüedades y añadiendo criterios medibles donde aplique.

---

### Requerimientos Explícitos

| ID    | Redacción original | Redacción corregida |
|-------|-------------------|---------------------|
| RE-01 | Los usuarios deben poder registrarse como entrenadores. | El sistema debe permitir que un usuario cree una cuenta de entrenador proporcionando al menos nombre de usuario, correo electrónico y contraseña, completando el registro en menos de 3 pasos. |
| RE-02 | El sistema debe permitir gestionar Pokémon propios. | El sistema debe permitir al entrenador agregar, visualizar, editar y eliminar Pokémon de su colección personal, mostrando al menos nombre, tipo, nivel y movimientos de cada uno. |
| RE-03 | El sistema debe permitir crear equipos de Pokémon. | El sistema debe permitir al entrenador crear, nombrar, editar y eliminar equipos de combate conformados por un mínimo de 1 y un máximo de 6 Pokémon de su colección. |
| RE-04 | El sistema debe soportar combates entre jugadores en línea. | El sistema debe permitir que dos entrenadores registrados inicien un combate en línea por turnos, sincronizando el estado de la partida entre ambos jugadores en tiempo real. |
| RE-05 | El sistema debe permitir la interacción entre jugadores. | El sistema debe permitir que los entrenadores envíen y reciban solicitudes de combate a otros jugadores registrados dentro de la plataforma. |
| RE-06 | El sistema debe mostrar el progreso del entrenador en la liga. | El sistema debe mostrar en el perfil de cada entrenador su nivel en la liga, puntos acumulados, número de victorias, derrotas y racha actual, actualizados tras cada combate. |
| RE-07 | El sistema debe garantizar una buena experiencia durante los combates. | El sistema debe garantizar que la interfaz de combate responda a las acciones del usuario en un tiempo máximo de 2 segundos, sin interrupciones visuales ni pérdida de estado durante la partida. |
| RE-08 | El sistema debe soportar múltiples usuarios simultáneos. | El sistema debe soportar al menos 1000 usuarios conectados simultáneamente sin degradar el tiempo de respuesta por encima de 3 segundos en operaciones estándar. |
| RE-09 | El sistema debe garantizar la seguridad de las cuentas. | El sistema debe proteger las cuentas de usuario mediante almacenamiento de contraseñas con bloqueo tras 5 intentos fallidos de inicio de sesión y soporte para autenticación en dos pasos. |
| RE-10 | El sistema debe proporcionar un historial de batallas claro. | El sistema debe mostrar al entrenador un historial paginado de sus últimas batallas, indicando para cada una: fecha, oponente, resultado (victoria/derrota), duración y Pokémon utilizados. |
| RE-11 | El sistema debe estar diseñado para escalar e incorporar torneos. | El sistema debe desarrollarse con una arquitectura modular que permita incorporar un módulo de torneos sin modificar los módulos existentes de combate o gestión de usuarios. |
| RE-12 | El sistema debe estar diseñado para incorporar recompensas. | El sistema debe exponer una interfaz interna (API o módulo) que permita asignar recompensas a entrenadores en función de eventos o logros, sin requerir cambios estructurales en el núcleo del sistema. |
| RE-13 | El sistema debe estar diseñado para incorporar modos de juego adicionales. | El sistema debe abstraer la lógica de combate de forma que nuevos modos de juego puedan integrarse como módulos independientes sin alterar el flujo de combate estándar. |

---

### Requerimientos Implícitos

| ID    | Redacción original | Redacción corregida |
|-------|-------------------|---------------------|
| RI-01 | El sistema debe autenticar a los usuarios. | El sistema debe autenticar a los usuarios mediante correo electrónico y contraseña, generando una sesión segura con token de expiración no mayor a 24 horas. |
| RI-02 | El sistema debe persistir los datos en una base de datos. | El sistema debe almacenar de forma persistente todos los datos de usuarios, Pokémon, equipos, combates e historial en una base de datos relacional o no relacional, garantizando integridad ante fallos. |
| RI-03 | El sistema debe permitir la recuperación de contraseña. | El sistema debe permitir al usuario restablecer su contraseña mediante un enlace de recuperación enviado al correo registrado, con una validez máxima de 30 minutos. |
| RI-04 | El sistema debe validar los datos ingresados en formularios. | El sistema debe validar en tiempo real los campos de todos los formularios, mostrando mensajes de error específicos por campo antes de permitir el envío de la solicitud. |
| RI-05 | El sistema debe contar con roles de usuario. | El sistema debe gestionar al menos dos roles: Entrenador (acceso a funciones de juego) y Administrador (acceso a gestión de usuarios, Pokémon del sistema y configuración de la liga), con permisos diferenciados. |
| RI-06 | El sistema debe permitir buscar otros jugadores para combatir. | El sistema debe permitir al entrenador buscar a otros jugadores por nombre de usuario y visualizar su perfil público antes de enviar una solicitud de combate. |
| RI-07 | El sistema debe sincronizar el combate en tiempo real. | El sistema debe sincronizar el estado del combate entre ambos jugadores con una latencia máxima de 500 ms, utilizando comunicación bidireccional en tiempo real. |
| RI-08 | El sistema debe manejar desconexiones sin corromper el estado del combate. | El sistema debe detectar la desconexión de un jugador durante un combate y conservar el estado de la partida durante al menos 60 segundos, permitiendo la reconexión sin pérdida de progreso. |
| RI-09 | El sistema debe mostrar estadísticas básicas de cada Pokémon. | El sistema debe mostrar para cada Pokémon al menos: nombre, tipo(s), nivel, puntos de vida (HP), ataque, defensa y lista de movimientos disponibles. |
| RI-10 | El sistema debe tener una interfaz responsiva. | El sistema debe adaptar su interfaz correctamente a resoluciones de escritorio, tablet y móvil, sin pérdida de funcionalidad en ninguno de estos tamaños. |
| RI-11 | El sistema debe registrar logs de actividad. | El sistema debe registrar automáticamente eventos críticos como inicios de sesión, cierres de sesión, intentos fallidos de autenticación, inicio y fin de combates, con marca de tiempo y usuario asociado. |
| RI-12 | El sistema debe cumplir con políticas de protección de datos. | El sistema debe cumplir con la normativa de protección de datos aplicable, informando al usuario sobre el uso de sus datos mediante una política de privacidad aceptada explícitamente durante el registro. |
| RI-13 | El sistema debe contar con un mecanismo de matchmaking. | El sistema debe emparejar automáticamente a dos entrenadores para combate basándose en criterios de nivel o puntos en la liga, encontrando un oponente en un tiempo máximo de 60 segundos. |
| RI-14 | El sistema debe mostrar el ranking de entrenadores en la liga. | El sistema debe mostrar una tabla de clasificación pública con los entrenadores ordenados por puntos en la liga, actualizada en tiempo real tras cada combate finalizado. |
| RI-15 | El sistema debe notificar a los usuarios sobre eventos relevantes. | El sistema debe enviar notificaciones dentro de la plataforma al entrenador cuando reciba una solicitud de combate, cuando un combate finalice o cuando ascienda de nivel en la liga, en un tiempo máximo de 5 segundos tras el evento. |

## 4. Priorización de Requerimientos

**Criterios utilizados:**
- **Alta:** Requerimientos críticos para el funcionamiento base del sistema,
  sin los cuales la aplicación no puede operar ni ofrecer valor al usuario.
- **Media:** Requerimientos importantes para la calidad y experiencia del sistema,
  pero que no bloquean el funcionamiento esencial.
- **Baja:** Requerimientos deseables a futuro, de optimización o extensibilidad,
  que no afectan el núcleo operativo actual.

---

### Requerimientos Explícitos

| ID    | Requerimiento (resumido) | Prioridad | Justificación |
|-------|--------------------------|-----------|---------------|
| RE-01 | Registro de entrenadores | Alta | Es la puerta de entrada al sistema. Sin registro no existe ningún otro flujo funcional. Dependencia directa de todos los demás requerimientos. |
| RE-02 | Gestión de Pokémon propios | Alta | El Pokémon es la unidad central del juego. Sin esta función no se pueden formar equipos ni realizar combates. |
| RE-03 | Creación de equipos | Alta | Dependencia directa del combate. Un entrenador no puede combatir sin un equipo formado previamente. |
| RE-04 | Combates en línea | Alta | Es el núcleo del negocio y la razón principal de la aplicación. Sin esta función el producto no tiene propósito. |
| RE-05 | Interacción entre jugadores | Alta | Sin la capacidad de retarse entre jugadores, el sistema de combate no puede iniciarse. |
| RE-06 | Progreso del entrenador en la liga | Media | Enriquece la experiencia y motiva la retención, pero no bloquea el funcionamiento del combate en sí. |
| RE-07 | Buena experiencia durante combates | Media | Afecta directamente la satisfacción del usuario, pero su medición y ajuste pueden refinarse en iteraciones posteriores al lanzamiento inicial. |
| RE-08 | Soporte de múltiples usuarios simultáneos | Alta | Sin capacidad de concurrencia adecuada, el sistema colapsaría en condiciones reales de uso, comprometiendo toda la plataforma. |
| RE-09 | Seguridad de las cuentas | Alta | La ausencia de seguridad expone datos de usuarios y puede generar pérdida de confianza, sanciones legales y abandono de la plataforma. |
| RE-10 | Historial de batallas | Media | Aporta valor a la experiencia del usuario y a la transparencia, pero no es indispensable para que el combate funcione. |
| RE-11 | Escalabilidad para torneos | Baja | Funcionalidad futura no definida completamente. Debe contemplarse en el diseño arquitectónico pero no implementarse en la fase inicial. |
| RE-12 | Escalabilidad para recompensas | Baja | Igual que los torneos, es una funcionalidad futura. Se debe diseñar pensando en ella, pero no desarrollar en esta etapa. |
| RE-13 | Escalabilidad para modos de juego adicionales | Baja | No está definida ni priorizada por el cliente. Su valor es arquitectónico a largo plazo. |

---

### Requerimientos Implícitos

| ID    | Requerimiento (resumido) | Prioridad | Justificación |
|-------|--------------------------|-----------|---------------|
| RI-01 | Autenticación de usuarios | Alta | Sin autenticación no hay control de acceso ni identidad de entrenador. Es prerequisito de absolutamente todos los flujos del sistema. |
| RI-02 | Persistencia de datos | Alta | Sin base de datos no existe progreso, historial ni estado de ningún tipo. El sistema sería completamente volátil e inútil. |
| RI-03 | Recuperación de contraseña | Media | Mejora la seguridad y accesibilidad de la cuenta, pero no bloquea el funcionamiento inicial del sistema. |
| RI-04 | Validación de formularios | Alta | Sin validación el sistema puede recibir datos corruptos o maliciosos que comprometan la integridad de la base de datos y la seguridad. |
| RI-05 | Roles de usuario | Alta | El rol de administrador es necesario para gestionar la liga, los usuarios y el contenido del sistema desde el inicio. |
| RI-06 | Búsqueda de jugadores | Alta | Es el mecanismo mediante el cual los entrenadores se encuentran para combatir. Sin él, los combates no pueden iniciarse manualmente. |
| RI-07 | Sincronización en tiempo real del combate | Alta | Un combate por turnos en línea requiere sincronización inmediata. Sin esto, el combate es técnicamente imposible o inconsistente. |
| RI-08 | Manejo de desconexiones | Media | Importante para la confiabilidad, pero puede implementarse de forma básica en una primera versión y refinarse posteriormente. |
| RI-09 | Estadísticas de Pokémon | Alta | Sin estas estadísticas el jugador no puede tomar decisiones de combate informadas, lo que hace el sistema injugable. |
| RI-10 | Interfaz responsiva | Media | Mejora el alcance del producto, pero puede priorizarse escritorio en la primera versión si el cliente así lo define. |
| RI-11 | Logs de actividad | Media | Esencial para auditoría y soporte técnico, pero no impacta directamente la experiencia del usuario final en el lanzamiento. |
| RI-12 | Cumplimiento de protección de datos | Alta | Es una obligación legal desde el primer día de operación. Su ausencia puede generar sanciones antes del lanzamiento oficial. |
| RI-13 | Matchmaking automático | Media | Complementa el sistema de combate, pero en una primera versión puede reemplazarse por búsqueda manual de oponentes (RI-06). |
| RI-14 | Ranking de entrenadores | Media | Refuerza la competitividad y retención, pero requiere primero que existan combates registrados. Puede implementarse en una segunda iteración. |
| RI-15 | Notificaciones en plataforma | Media | Mejora la experiencia y la retención del usuario, pero no es bloqueante para el funcionamiento del sistema en su versión inicial. |

---

### Resumen de Prioridades

| Prioridad | Cantidad | IDs |
|-----------|----------|-----|
| Alta      | 16       | RE-01, RE-02, RE-03, RE-04, RE-05, RE-08, RE-09, RI-01, RI-02, RI-04, RI-05, RI-06, RI-07, RI-09, RI-12 |
| Media     | 9        | RE-06, RE-07, RE-10, RI-03, RI-08, RI-10, RI-11, RI-13, RI-14, RI-15 |
| Baja      | 3        | RE-11, RE-12, RE-13 |


## 5. Identificación de Dependencias y Bloqueos

---

### 5.1 Mapa de Dependencias

Vamos a considerar que un requerimiento **depende** de otro cuando no puede implementarse ni probarse
sin que el requerimiento del que depende esté previamente resuelto.

| ID | Requerimiento (resumido) | Depende de | Tipo de dependencia |
|----|--------------------------|------------|---------------------|
| RE-01 | Registro de entrenadores | RI-02 | El registro debe persistirse en base de datos. |
| RI-01 | Autenticación de usuarios | RE-01 | Solo puede autenticarse un usuario previamente registrado. |
| RE-02 | Gestión de Pokémon | RI-01, RI-02 | Requiere sesión activa y persistencia de datos. |
| RE-03 | Creación de equipos | RE-02, RI-01 | Solo se pueden armar equipos con Pokémon ya registrados en la colección. |
| RE-04 | Combates en línea | RE-03, RI-01, RI-07 | Requiere equipos formados, sesión activa y sincronización en tiempo real. |
| RE-05 | Interacción entre jugadores | RI-01, RI-06 | Requiere que ambos jugadores estén autenticados y puedan encontrarse. |
| RE-06 | Progreso del entrenador | RE-04, RI-02 | El progreso se genera a partir de combates finalizados y persistidos. |
| RE-07 | Experiencia durante combates | RE-04, RI-07 | Solo puede evaluarse y optimizarse cuando el combate ya funciona. |
| RE-08 | Soporte de usuarios simultáneos | RI-02, RI-07 | Depende de la infraestructura de base de datos y comunicación en tiempo real. |
| RE-09 | Seguridad de cuentas | RI-01, RE-01 | La seguridad se aplica sobre el sistema de autenticación y registro. |
| RE-10 | Historial de batallas | RE-04, RI-02 | Solo puede generarse historial si los combates se ejecutan y persisten correctamente. |
| RI-03 | Recuperación de contraseña | RE-01, RI-01 | Solo aplica sobre cuentas existentes con sistema de autenticación activo. |
| RI-04 | Validación de formularios | RE-01, RE-02, RE-03 | Se aplica sobre todos los formularios del sistema, que deben existir primero. |
| RI-05 | Roles de usuario | RI-01, RI-02 | Los roles se asignan al momento del registro y se gestionan desde la base de datos. |
| RI-06 | Búsqueda de jugadores | RI-01, RI-02 | Requiere usuarios registrados y persistidos para poder buscarlos. |
| RI-07 | Sincronización en tiempo real | RE-04, RE-08 | Depende del módulo de combate y de la infraestructura de concurrencia. |
| RI-08 | Manejo de desconexiones | RI-07, RE-04 | Solo ocurre en el contexto de un combate sincronizado en tiempo real. |
| RI-09 | Estadísticas de Pokémon | RE-02, RI-02 | Las estadísticas pertenecen a Pokémon ya registrados y persistidos. |
| RI-10 | Interfaz responsiva | RE-01 a RE-10 | Aplica sobre todas las vistas del sistema, que deben existir primero. |
| RI-11 | Logs de actividad | RI-01, RE-04, RE-09 | Se registran eventos de autenticación, combates y seguridad. |
| RI-12 | Protección de datos | RE-01, RI-02 | Se aplica desde el momento en que se recolectan y almacenan datos personales. |
| RI-13 | Matchmaking automático | RE-05, RI-06, RE-04 | Requiere que los jugadores puedan encontrarse y que el combate pueda iniciarse. |
| RI-14 | Ranking de entrenadores | RE-06, RE-04, RI-02 | El ranking se calcula a partir del progreso generado por combates persistidos. |
| RI-15 | Notificaciones en plataforma | RE-05, RI-13, RE-04 | Las notificaciones se disparan por eventos como retos, matchmaking y resultados. |
| RE-11 | Escalabilidad para torneos | RE-04, RI-13, RI-14 | Un torneo presupone combates, matchmaking y ranking ya funcionales. |
| RE-12 | Escalabilidad para recompensas | RE-06, RI-14 | Las recompensas dependen del progreso y ranking del entrenador. |
| RE-13 | Escalabilidad para modos de juego | RE-04, RE-03 | Cualquier nuevo modo parte de la lógica base de equipos y combate. |

---

### 5.2 Identificación de Bloqueos

Vamos a considerar como **bloqueo** a una condición externa o interna que puede impedir o retrasar
el desarrollo de uno o más requerimientos.

| ID Bloqueo | Requerimientos afectados | Descripción del bloqueo                                                                                                                                                           | Estrategia de mitigación |
|------------|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|
| BLQ-01 | RE-04, RI-07 | **Tecnología de tiempo real no definida.** No se ha especificado que otra tecnología se usara para el combate en línea.                                                           | Realizar un spike técnico temprano para validar la tecnología antes de iniciar el desarrollo del módulo de combate. |
| BLQ-02 | RE-11, RE-12, RE-13 | **Requerimientos futuros sin definir.** El cliente no ha especificado reglas, estructura ni flujos de torneos, recompensas o modos adicionales.                                   | Documentar como requerimientos pendientes y diseñar la arquitectura con interfaces abiertas (módulos desacoplados). |
| BLQ-03 | RI-12, RE-09 | **Marco legal no identificado.** No se sabe en qué país operará la plataforma, por lo que no se puede definir la normativa de protección de datos aplicable.                      | Consultar con el cliente la región de operación y asesorarse legalmente antes del lanzamiento. |
| BLQ-04 | RE-08, RI-07 | **Infraestructura de servidores no definida.** No se conoce el proveedor de nube ni la capacidad de los servidores, lo que impide dimensionar correctamente la concurrencia.      | Definir con el cliente el presupuesto de infraestructura y realizar pruebas de carga en un entorno controlado. |
| BLQ-05 | RE-02, RI-09 | **Catálogo de Pokémon no definido.** No se sabe si los Pokémon serán predefinidos por el sistema, creados por el usuario o consumidos desde una API externa (como PokéAPI).       | Acordar con el cliente el origen de los datos de Pokémon antes de desarrollar el módulo de gestión. |
| BLQ-06 | RI-13 | **Criterios de matchmaking sin definir.** No está claro si el emparejamiento será por nivel, puntos, región u otro criterio, lo que impide diseñar el algoritmo.                  | Validar con el cliente las reglas de emparejamiento en una sesión de levantamiento de requerimientos. |
| BLQ-07 | RI-15 | **Canal de notificaciones no definido.** No se especifica si las notificaciones serán solo dentro de la plataforma, por correo electrónico, push notifications o una combinación. | Definir el alcance de las notificaciones con el cliente antes de iniciar el desarrollo del módulo. |

---

## 6. Matriz de Trazabilidad

| ID    | Tipo | Módulo / Caso de uso asociado | Posible prueba o validación |
|-------|------|-------------------------------|----------------------------|
| RE-01 | RF | Módulo de Registro | Verificar que un usuario puede crear una cuenta con datos válidos y que el sistema rechaza datos incompletos o duplicados. |
| RE-02 | RF | Módulo de Gestión de Pokémon | Verificar que el entrenador puede agregar, editar, visualizar y eliminar Pokémon de su colección correctamente. |
| RE-03 | RF | Módulo de Equipos | Verificar que se puede crear un equipo con entre 1 y 6 Pokémon y que el sistema rechaza equipos fuera de ese rango. |
| RE-04 | RF | Módulo de Combate | Verificar que dos entrenadores con equipos formados pueden iniciar y completar un combate en línea por turnos. |
| RE-05 | RF | Módulo de Interacción / Social | Verificar que un entrenador puede enviar y recibir solicitudes de combate a otros jugadores registrados. |
| RE-06 | RF | Módulo de Liga / Perfil | Verificar que el perfil muestra victorias, derrotas, puntos y nivel actualizados tras cada combate finalizado. |
| RE-07 | RNF | Módulo de Combate / UX | Medir el tiempo de respuesta de la interfaz de combate ante acciones del usuario; debe ser menor a 2 segundos. |
| RE-08 | RNF | Infraestructura / Concurrencia | Ejecutar prueba de carga con al menos 1000 usuarios simultáneos y verificar que el tiempo de respuesta no supere 3 segundos. |
| RE-09 | RNF | Módulo de Autenticación / Seguridad | Verificar que las contraseñas se almacenan hasheadas, que la cuenta se bloquea tras 5 intentos fallidos y que el 2FA funciona correctamente. |
| RE-10 | RF | Módulo de Historial | Verificar que el historial muestra fecha, oponente, resultado, duración y Pokémon usados para cada batalla registrada. |
| RE-11 | RNF | Arquitectura del sistema | Revisar que el diseño arquitectónico permite agregar un módulo de torneos sin modificar los módulos existentes. |
| RE-12 | RNF | Arquitectura del sistema | Verificar que existe una interfaz o API interna que permita asignar recompensas sin cambios estructurales en el núcleo. |
| RE-13 | RNF | Arquitectura del sistema | Verificar que la lógica de combate está abstraída de forma que permita integrar nuevos modos como módulos independientes. |
| RI-01 | RF | Módulo de Autenticación | Verificar que un usuario registrado puede iniciar sesión y que el token de sesión expira correctamente a las 24 horas. |
| RI-02 | RNF | Infraestructura / Base de datos | Verificar que los datos persisten correctamente tras reinicios del sistema y que no se pierden ante fallos controlados. |
| RI-03 | RF | Módulo de Autenticación | Verificar que el enlace de recuperación de contraseña llega al correo registrado y expira a los 30 minutos. |
| RI-04 | RF | Todos los formularios del sistema | Verificar que cada campo muestra un mensaje de error específico ante datos inválidos antes de permitir el envío. |
| RI-05 | RF | Módulo de Administración / Roles | Verificar que un administrador accede a funciones restringidas y que un entrenador no puede acceder a ellas. |
| RI-06 | RF | Módulo de Búsqueda de Jugadores | Verificar que un entrenador puede buscar a otro por nombre de usuario y visualizar su perfil público correctamente. |
| RI-07 | RNF | Módulo de Combate / Tiempo real | Medir la latencia de sincronización entre ambos jugadores durante un combate; debe ser menor a 500 ms. |
| RI-08 | RNF | Módulo de Combate / Resiliencia | Simular la desconexión de un jugador y verificar que el estado del combate se conserva al menos 60 segundos. |
| RI-09 | RF | Módulo de Gestión de Pokémon | Verificar que cada Pokémon muestra nombre, tipo, nivel, HP, ataque, defensa y movimientos disponibles. |
| RI-10 | RNF | Interfaz general del sistema | Verificar que todas las vistas se renderizan correctamente en resoluciones de escritorio, tablet y móvil sin pérdida de funcionalidad. |
| RI-11 | RNF | Módulo de Logs / Auditoría | Verificar que el sistema registra con marca de tiempo los eventos de autenticación, combate e intentos fallidos de acceso. |
| RI-12 | RNF | Módulo de Registro / Legal | Verificar que el usuario debe aceptar explícitamente la política de privacidad durante el registro y que no puede omitirla. |
| RI-13 | RF | Módulo de Matchmaking | Verificar que el sistema empareja dos entrenadores automáticamente en un tiempo máximo de 60 segundos. |
| RI-14 | RF | Módulo de Liga / Ranking | Verificar que la tabla de clasificación se actualiza correctamente tras cada combate finalizado y refleja el orden real por puntos. |
| RI-15 | RF | Módulo de Notificaciones | Verificar que el entrenador recibe una notificación dentro de la plataforma en menos de 5 segundos tras recibir un reto o finalizar un combate. |

--- 

## 7. Análisis de Ambigüedades

Se identifican aspectos del enunciado que son ambiguos, están incompletos
o requieren validación directa con el cliente antes de continuar el desarrollo.

---

### 7.1 Aspectos Ambiguos

| ID | Aspecto | Descripción de la ambigüedad | Pregunta al cliente |
|----|---------|------------------------------|---------------------|
| AMB-01 | "Buena experiencia durante los combates" | El enunciado menciona preocupación por la experiencia del usuario en combates, pero no define qué significa "buena experiencia": ¿fluidez visual, velocidad de respuesta, diseño intuitivo, ausencia de bugs? | ¿Qué criterios específicos definen una experiencia satisfactoria durante el combate? ¿Existe algún referente o juego similar al que se quiera parecerse? |
| AMB-02 | "Interacción entre jugadores" | No queda claro el alcance de la interacción: ¿se limita a enviarse retos de combate o incluye chat, sistema de amigos, intercambio de Pokémon, foros u otras formas de comunicación? | ¿Qué tipos de interacción entre jugadores se esperan en la primera versión del sistema? |
| AMB-03 | "Claridad en el historial de batallas" | El cliente menciona que le preocupa la claridad del historial, pero no especifica qué datos deben mostrarse, con qué nivel de detalle, durante cuánto tiempo se conserva o si debe ser público o privado. | ¿Qué información debe contener el historial de batallas? ¿Es visible para otros jugadores o solo para el entrenador dueño de la cuenta? |
| AMB-04 | "Liga competitiva" | No se define qué es la liga: ¿tiene temporadas, divisiones, ascensos y descensos, premios? ¿Es una sola liga global o hay ligas por región o nivel? | ¿Cómo está estructurada la liga competitiva? ¿Existen divisiones, temporadas o criterios de ascenso y descenso? |
| AMB-05 | "Gestionar sus Pokémon" | El término gestionar es amplio. No se especifica si los Pokémon pueden ser capturados, comprados, intercambiados, evolucionados o simplemente seleccionados de un catálogo fijo. | ¿Cómo obtiene un entrenador sus Pokémon? ¿Existe un catálogo predefinido, un sistema de captura, compra o intercambio? |

---

### 7.2 Aspectos Incompletos

| ID | Aspecto | Información faltante | Impacto si no se resuelve |
|----|---------|----------------------|---------------------------|
| INC-01 | Reglas del sistema de combate | No se describe el sistema de combate: ¿es por turnos, en tiempo real, basado en estadísticas, con animaciones? ¿Cuántos Pokémon participan por combate? | Sin estas reglas no es posible diseñar ni desarrollar el módulo central del sistema. Bloquea RE-04 completamente. |
| INC-02 | Origen y catálogo de Pokémon | No se define si los Pokémon provienen de una API externa (como PokéAPI), son creados por el equipo de desarrollo o pueden ser personalizados por el usuario. | Impacta directamente el diseño de la base de datos, el módulo de gestión y las estadísticas de combate. Bloquea RE-02 y RI-09. |
| INC-03 | Torneos, recompensas y modos adicionales | El cliente menciona estas funcionalidades futuras pero no entrega ningún detalle sobre su estructura, reglas ni cronograma esperado. | Sin esta información no es posible diseñar una arquitectura que las soporte correctamente, arriesgando rediseños costosos. |
| INC-04 | Plataforma y dispositivos objetivo | No se especifica si la aplicación web debe funcionar también como app móvil, si se priorizará escritorio o si habrá una versión nativa en el futuro. | Afecta decisiones de diseño de interfaz, tecnología frontend y esfuerzo de desarrollo desde las primeras iteraciones. |
| INC-05 | Modelo de negocio y monetización | No se menciona si la plataforma será gratuita, freemium o de pago, ni si habrá compras dentro del juego, lo que puede afectar el diseño de roles y recompensas. | Sin claridad en el modelo de negocio es difícil priorizar funcionalidades y diseñar el sistema de recompensas futuro. |

---

### 7.3 Aspectos que Requieren Validación con el Cliente

| ID | Aspecto | Razón por la que requiere validación | Riesgo si no se valida |
|----|---------|--------------------------------------|------------------------|
| VAL-01 | Número de usuarios simultáneos esperados | El cliente menciona preocupación por la concurrencia pero no da una cifra. Se asumió 1000 usuarios como referencia, pero puede ser muy distinto a la realidad del negocio. | Subdimensionar la infraestructura generaría caídas del sistema; sobredimensionarla generaría costos innecesarios. |
| VAL-02 | Normativa legal aplicable | No se conoce el país o región de operación de la plataforma, por lo que no es posible determinar qué ley de protección de datos aplica. | Lanzar el sistema sin cumplir la normativa correspondiente puede resultar en sanciones legales o el cierre de la plataforma. |
| VAL-03 | Criterios de seguridad aceptables | El cliente menciona seguridad como preocupación pero no define el nivel requerido: ¿es suficiente usuario y contraseña o se exige 2FA obligatorio, cifrado en tránsito, auditorías periódicas? | Implementar un nivel de seguridad insuficiente expone la plataforma a vulnerabilidades; uno excesivo puede encarecer y retrasar el desarrollo. |
| VAL-04 | Definición de "progreso" en la liga | No está claro cómo se calcula el progreso: ¿por puntos, por victorias consecutivas, por tipo de oponente derrotado, por combinación de factores? | Un sistema de puntuación mal diseñado puede percibirse como injusto, afectando la retención y competitividad de la plataforma. |
| VAL-05 | Rol y permisos del administrador | No se describe qué acciones puede realizar un administrador: ¿puede banear jugadores, modificar Pokémon del sistema, reiniciar la liga, gestionar torneos? | Sin definir esto no es posible diseñar correctamente el módulo de administración ni los permisos del sistema. |