
# Resolución de Rutas Óptimas Entre Ciudades usando Dijkstra con TDA

## Problema Real

En el contexto de la logística y el transporte internacional, una empresa con presencia global necesita optimizar la elección de rutas entre sus centros de distribución, situados en diferentes ciudades estratégicas. Por ejemplo, algunas de estas ciudades pueden ser Amsterdam, Buenos Aires, California, Douglas, El Cairo y Filadelfia.

Cada conexión entre ciudades tiene un costo asociado, que puede representar distancia recorrida, tiempo de tránsito, consumo de combustible o un costo económico específico. La empresa desea implementar una solución computacional que no solo determine el camino más corto entre dos ubicaciones, sino que también permita observar la evolución del proceso de cálculo paso a paso, con fines analíticos y de auditoría.

## Solución Implementada

Se desarrolló una aplicación modular en Java, basada en el algoritmo de Dijkstra, utilizando exclusivamente Tipos Abstractos de Datos (TDA), sin estructuras de datos avanzadas como `HashMap` o `Set`. El objetivo de esta elección fue demostrar que es posible implementar algoritmos de grafos de manera clara y eficiente utilizando únicamente listas secuenciales (`ArrayList`), facilitando así su comprensión y adaptación en contextos educativos o entornos de bajo nivel de abstracción.

### Estructura de Clases

- **`Grafo`**: Administra la lista de ciudades y las conexiones entre ellas mediante listas de adyacencia. Es capaz de manejar tanto grafos dirigidos como no dirigidos.
- **`Arista`**: Representa una conexión entre dos ciudades, conteniendo la ciudad destino y el peso o costo de la conexión.
- **`Dijkstra`**: Implementa el algoritmo de búsqueda de camino mínimo. Realiza el cálculo paso a paso, mantiene una tabla combinada de distancias y nodos anteriores, y permite reconstruir el camino final desde el nodo origen hasta el destino seleccionado.
- **`Main`**: Actúa como interfaz de usuario básica, permitiendo la selección de tipo de grafo (dirigido o no dirigido), ingreso de ciudad origen y destino, y presentación de resultados.

### Funcionalidades Especiales

- Permite al usuario indicar si el grafo es dirigido o no dirigido.
- Permite elegir el origen y destino.
- Muestra una tabla paso a paso con:
  - Distancia estimada desde el origen.
  - Nodo anterior en el camino.
- Reconstruye y muestra el camino final con su distancia total.
- Uso exclusivo de `ArrayList` (sin `Map`, `Set`, etc.).

## Ejemplo de Grafo

Para ilustrar el uso del algoritmo, se utilizó el siguiente conjunto de ciudades y conexiones:

```
Amsterdam <--> Buenos Aires (4)
Amsterdam <--> California (2)
Buenos Aires <--> California (5)
Buenos Aires <--> Douglas (10)
California <--> El Cairo (3)
El Cairo <--> Douglas (4)
Douglas <--> Filadelfia (11)
```

Este grafo no dirigido representa un escenario donde las conexiones entre centros logísticos están definidas y cuantificadas, y se desea encontrar la mejor ruta entre cualquier par de nodos.

## Comparación con el Algoritmo Básico de Dijkstra

| Característica                         | Algoritmo Básico                     | Implementación Actual                                       |
|---------------------------------------|--------------------------------------|-------------------------------------------------------------|
| Estructura de datos                   | Arrays, `Map`, `Set`                 | Solo `ArrayList`, sin estructuras de mapeo o conjuntos      |
| Salida final                          | Camino mínimo y distancia            | Camino mínimo, distancia total y evolución paso a paso      |
| Visualización de progreso             | No                                   | Sí, mediante tabla detallada de (distancia, nodo anterior)  |
| Interactividad del usuario            | No                                   | Sí, con selección de ciudades y tipo de grafo               |
| Modularidad y uso de interfaces (TDA) | No                                   | Sí, interfaces `IGrafo` y `IDijkstra` permiten escalabilidad |

## Conclusión

Esta implementación extiende el algoritmo clásico de Dijkstra para hacerlo más versátil, transparente y didáctico. Su estructura modular basada en interfaces facilita la adaptación y mejora del código, además de permitir pruebas automáticas y reutilización de componentes.

El uso exclusivo de estructuras básicas (`ArrayList`) demuestra que es posible construir sistemas eficientes sin recurrir a abstracciones complejas, lo que resulta útil tanto en contextos académicos como en entornos de bajo nivel de recursos.

Finalmente, la capacidad de visualizar la evolución del algoritmo paso a paso proporciona una herramienta valiosa para el análisis y la comprensión de los procesos de optimización en redes de transporte y logística.
