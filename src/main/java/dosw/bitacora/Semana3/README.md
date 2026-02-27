# Patrones de Diseño – Ejercicios Carpeta DOSW

Este documento describe cada patrón trabajado indicando:

-  El problema planteado
-  Breve descripción del patrón
-  Cómo se implementó en el ejercicio

---

# 1. Factory Method

##  Problema
Una plataforma de comercio electrónico procesa pagos con distintos métodos:
- Tarjeta de crédito
- PayPal
- Transferencia bancaria

Los pagos manejan valores decimales y deben mostrar:

> Pago con METODO por $ MONTO

El sistema no debe acoplarse a clases concretas de pago.

##  Descripción del patrón
Factory Method define una interfaz para crear objetos, pero deja que las subclases decidan qué clase concreta instanciar.

Permite desacoplar la creación del objeto del código cliente.

##  Implementación
- Se creó una interfaz `Pago` con el método `procesarPago(double monto)`.
- Se implementaron clases concretas: `PagoTarjeta`, `PagoPaypal`, `PagoTransferencia`.
- Se creó una clase abstracta `PagoFactory` con el método `crearPago()`.
- Las fábricas concretas instancian el tipo específico de pago.
- El sistema trabaja únicamente con la abstracción `Pago`.

---

# 2. Abstract Factory

##  Problema
Una empresa desarrolla videojuegos para diferentes consolas:
- PlayStation
- Xbox

Cada consola tiene una familia compatible de:
- Control (se conecta)
- Juego (se inicia)
- Interfaz gráfica (renderiza)

El motor del juego no debe conocer implementaciones concretas.

##  Descripción del patrón
Abstract Factory permite crear familias de objetos relacionados sin especificar sus clases concretas.

Garantiza que los productos creados sean compatibles entre sí.

##  Implementación
- Se crearon interfaces: `Control`, `Juego`, `InterfazGrafica`.
- Se creó la interfaz `ConsolaFactory` con métodos para crear cada componente.
- `PlayStationFactory` y `XboxFactory` implementan la fábrica.
- El motor del juego recibe una `ConsolaFactory` y crea los objetos sin conocer clases concretas.

---

# 3. Builder

##  Problema
Una fábrica produce distintos tipos de muñecos:
- Muñeco de acción
- Muñeca clásica

Todos tienen:
- Cabeza
- Cuerpo
- Brazos
- Piernas
- Accesorios opcionales

El proceso de construcción es el mismo, pero el resultado final varía.

##  Descripción del patrón
Builder separa la construcción de un objeto complejo de su representación final.

Permite crear diferentes configuraciones usando el mismo proceso.

##  Implementación
- Se creó la clase `Muneco` con todas sus partes.
- Se definió la interfaz `MunecoBuilder` con pasos de construcción.
- Se implementaron `MunecoAccionBuilder` y `MunecaClasicaBuilder`.
- Se creó un `Director` que ejecuta el proceso de ensamblaje.

---

# 4. Adapter

##  Problema
Una gasolinería atiende vehículos de combustión con un sistema estándar.
Ahora debe integrar cargadores eléctricos con interfaces incompatibles.

El sistema central no debe cambiar.

Conversión:
- Modelo rápido → litros * 8.0
- Modelo lento → litros * 7.0

##  Descripción del patrón
Adapter convierte la interfaz de una clase en otra que el cliente espera.

Permite reutilizar código existente sin modificarlo.

##  Implementación
- Se definió una interfaz común `SistemaAbastecimiento`.
- Los cargadores eléctricos existentes no se modificaron.
- Se crearon clases adaptadoras que implementan la interfaz estándar.
- Internamente convierten litros a KWh según el modelo.
- El sistema central trabaja únicamente con la interfaz unificada.

---

# 5. Bridge

##  Problema
Existe la jerarquía:
- Forma → Círculo, Cuadrado

Al agregar colores, la cantidad de combinaciones crece exponencialmente.

##  Descripción del patrón
Bridge separa una abstracción de su implementación usando composición en lugar de herencia.

Permite que ambas dimensiones evolucionen independientemente.

##  Implementación
- Se creó la interfaz `Color`.
- Se creó la clase abstracta `Forma` que contiene un `Color`.
- `Circulo` y `Cuadrado` extienden `Forma`.
- `Rojo`, `Azul`, etc., implementan `Color`.

Las combinaciones se realizan dinámicamente en tiempo de ejecución.

---

# 6. Composite

##  Problema
Una bodega maneja:
- Productos individuales
- Cajas que contienen productos u otras cajas

Debe calcularse el precio total sin importar la estructura.

##  Descripción del patrón
Composite permite tratar objetos individuales y compuestos de manera uniforme.

Facilita trabajar con estructuras en forma de árbol.

##  Implementación
- Se creó la interfaz `Item` con `obtenerPrecio()`.
- `Producto` representa elementos simples.
- `Caja` contiene una lista de `Item`.
- `Caja` recorre sus elementos y suma los precios.

---

# 7. Decorator

##  Problema
Un simulador naval permite equipar barcos con módulos adicionales:
- Blindaje reforzado (+30 defensa)
- Radar (+10 ataque)
- Misiles (+40 ataque)
- Sistema antitorpedos (+20 ataque)

Se pueden combinar múltiples mejoras dinámicamente.
No se permiten subclases combinadas.

##  Descripción del patrón
Decorator permite agregar responsabilidades a un objeto dinámicamente sin modificar su clase original.

##  Implementación
- Se creó la interfaz `Barco`.
- `BarcoBase` implementa capacidades básicas.
- Se creó un decorador abstracto que implementa `Barco`.
- Cada módulo es un decorador concreto.
- Se pueden encadenar múltiples decoradores.

---

# 8. Chain of Responsibility

##  Problema
Una persona ingresa a Estados Unidos y pasa por:
- Revisión de pasaporte
- Control de antecedentes
- Motivo del viaje
- Aprobación final

Cada control puede aprobar o rechazar.

##  Descripción del patrón
Permite pasar una solicitud a través de una cadena de manejadores hasta que uno la procese o la rechace.

##  Implementación
- Se creó la clase abstracta `ControlMigratorio`.
- Cada control extiende la clase.
- Cada handler tiene referencia al siguiente.
- Si aprueba, delega; si rechaza, detiene la cadena.

---

# 9. Command

##  Problema
Un personaje puede:
- Caminar
- Saltar
- Atacar
- Defenderse

El controlador no debe conocer la implementación interna.

##  Descripción del patrón
Command encapsula una solicitud como un objeto.

Desacopla el invocador del receptor.

##  Implementación
- Se creó la interfaz `Command` con `execute()`.
- Cada acción es un comando concreto.
- El personaje es el receptor.
- El controlador ejecuta comandos sin conocer detalles.

---

# 10. Iterator

##  Problema
Un turista recorre lugares de Roma:
- Coliseo
- Foro Romano
- Fontana di Trevi
- Panteón
- Plaza de España

Debe iterarse sin exponer la estructura interna.

##  Descripción del patrón
Iterator proporciona una forma de acceder secuencialmente a los elementos de una colección sin exponer su representación interna.

##  Implementación
- Se creó una colección `RecorridoRoma`.
- Se implementó un iterador con métodos `hasNext()` y `next()`.
- El cliente recorre los lugares sin conocer cómo se almacenan.

---

# 11. Strategy

##  Problema
Una aplicación de navegación calcula rutas de distintas maneras.
El algoritmo puede cambiar según preferencia del usuario.

No debe modificarse la aplicación principal.

##  Descripción del patrón
Strategy define una familia de algoritmos intercambiables.

Permite cambiar el comportamiento dinámicamente.

##  Implementación
- Se creó la interfaz `EstrategiaRuta`.
- Se implementaron diferentes algoritmos de cálculo.
- La aplicación mantiene una referencia a la estrategia.
- Puede cambiarse en tiempo de ejecución.

---


# Retroalimentación Personal

Durante el desarrollo de los ejercicios identifiqué varios retos importantes en mi proceso de aprendizaje y aplicación de los patrones de diseño.

## 1. Dificultad para identificar correctamente los roles del patrón
En varios ejercicios tuve dudas sobre qué clase debía ser abstracta, cuál debía ser interfaz y cuál concreta. Esto me pasó especialmente en:
- Chain of Responsibility (no tenía claro si el handler debía ser abstracto y cómo encadenarlo correctamente).
- Factory Method y Abstract Factory (me costó diferenciar claramente entre el creador y el producto).

Con el tiempo entendí que primero debía comprender la intención del patrón antes de empezar a programar.

## 2. Problemas de acoplamiento inicial
En mis primeros intentos, algunas implementaciones quedaron demasiado acopladas a clases concretas. Luego tuve que refactorizar para:
- Depender de interfaces.
- Aplicar correctamente el principio de inversión de dependencias.

Esto me ocurrió especialmente en Factory Method, Strategy y Command.

## 3. Confusión entre herencia y composición
En patrones como Bridge y Decorator entendí que muchas veces mi primera reacción era usar herencia para todo. Sin embargo, aprendí que la composición permite mayor flexibilidad y evita la explosión de clases.

Comprender esta diferencia fue uno de los aprendizajes más importantes.

## 4. Manejo de estructuras dinámicas
En Chain of Responsibility llegué a generar bucles involuntarios por no configurar correctamente el siguiente handler.

En Composite tuve que reforzar cómo recorrer correctamente estructuras tipo árbol manteniendo el tratamiento uniforme entre objetos simples y compuestos.

## 5. Encapsulamiento y separación de responsabilidades
En Builder y Adapter entendí mejor la importancia de:
- Separar el proceso de construcción del objeto final.
- No modificar código existente cuando se agregan nuevas funcionalidades.

Esto me ayudó a reforzar los principios SOLID en la práctica.

## 6. Cambio de mentalidad en el diseño
El aprendizaje más grande para mí no fue solo técnico, sino conceptual. Al inicio pensaba en resolver el problema de forma directa y rápida. Con estos ejercicios entendí que diseñar software implica pensar en:
- Escalabilidad
- Extensibilidad
- Bajo acoplamiento
- Alta cohesión

En general, mis mayores dificultades surgieron cuando intentaba programar sin estructurar primero la solución desde el patrón. A medida que avancé, empecé a identificar mejor cuándo aplicar cada patrón y cómo organizar las clases antes de escribir el código.

