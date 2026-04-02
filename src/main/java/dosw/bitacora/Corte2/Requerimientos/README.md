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