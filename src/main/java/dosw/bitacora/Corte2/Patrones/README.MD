# Refuerzo – Combinación de Patrones de Diseño
El objetivo de este refuerzo es practicar la combinación de patrones de diseño dentro de un mismo sistema, entendiendo 
cómo se complementan para resolver problemas reales de software.
Para cada ejercicio deberán realizar:
1. Identificar por cada uno de los patrones de diseño utilizados:
- Nombre del Patrón 
- Tipo del Patrón
- Justificación Técnica
2. Realizar el diagrama de clases UML mostrando claramente las relaciones entre las clases.
3. Implementar la solución en código.
4. Crear pruebas unitarias que validen el comportamiento del sistema con JUnit
5. Generar cobertura de código con Jacoco
6. Realizar análisis estático del código utilizando herramientas como Sonar



### Ejercicio 1: Sistema de Notificaciones
Una empresa necesita un sistema que envíe notificaciones a los usuarios a través de diferentes canales como:
- Email, SMS y Push Notification

El sistema debe permitir que el tipo de notificación pueda cambiar dinámicamente, dependiendo del canal seleccionado.
Además, se requiere que todas las notificaciones pasen por un servicio centralizado que gestione el envío, para evitar 
múltiples instancias del servicio en el sistema.
#### Requisitos
- El sistema debe permitir agregar nuevos tipos de notificación sin modificar el código existente.
- El servicio de envío debe existir una sola vez en el sistema.
- El sistema debe poder cambiar el comportamiento del envío según el canal elegido.

### Patrón 1: Decorator
#### 1.1 Nombre del Patrón
Decorator (Decorador)
#### 1.2 Tipo del Patrón
Estructural
#### 1.3 Justificación Técnica
El enunciado establece que el sistema debe enviar notificaciones a través de Email, SMS y Push Notification, y que el 
tipo de notificación debe cambiar dinámicamente según el canal seleccionado. Además exige que se puedan agregar nuevos 
tipos sin modificar el código existente.La herencia tradicional fallaría aquí porque generaría una explosión combinatoria 
de subclases, como lo explica el documento:

Email, SMS, Push, EmailSMS, EmailPush, SMSPush, EmailSMSPush...

El patrón Decorator resuelve esto porque:

Permite apilar comportamientos en tiempo de ejecución. Un usuario puede recibir Email + SMS + Push simultáneamente 
simplemente envolviendo decoradores uno sobre otro. 

Todos los decoradores implementan la misma interfaz que el notificador 
base, por lo que el cliente no distingue si trabaja con uno o varios canales activos. 

Agregar un nuevo canal como WhatsApp o Slack solo requiere crear un nuevo decorador, sin tocar ninguna clase existente 
→ cumple el principio Open/Closed

### Diagrama

![img.png](img.png)

### Patrón 2: Singleton
#### 2.1 Nombre del Patrón
Singleton
#### 2.2 Tipo del Patrón
Creacional
#### 2.3 Justificación Técnica
El enunciado dice explícitamente:

"Se requiere que todas las notificaciones pasen por un servicio centralizado que gestione el envío, para evitar 
múltiples instancias del servicio en el sistema"

Esa es la definición exacta del problema que resuelve Singleton:

Garantiza que el NotificationService tenga una única instancia en toda la aplicación
Proporciona un punto de acceso global a ese servicio desde cualquier parte del sistema
Evita inconsistencias que ocurrirían si múltiples instancias del servicio gestionaran el envío de forma independiente, 
como duplicación de mensajes o condiciones de carrera

### Diagrama

![img_1.png](img_1.png)


### Diagrama General

![img_2.png](img_2.png)