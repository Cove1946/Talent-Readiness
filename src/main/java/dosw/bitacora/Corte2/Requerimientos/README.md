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

