# 1-Parte-de-la-Pr-ctica
https://github.com/maridilo/1-Parte-de-la-Pr-ctica.git

Para realizar un conjunto de experimentos en un laboratorio de biólogos necesitan una aplicación de escritorio que les ayude a recoger la información de los experimentos. Los experimentos consisten en realizar cultivos de bacterias. En cada experimento se parte de una población de bacterias inicial. En el medio donde viven las bacterias se añade una determinada cantidad de comida. Esta cantidad de comida inicial irá incrementando linealmente durante varios días, y a continuación disminuye linealmente hasta un valor final. Todos los experimentos duran 30 días.

 

La aplicación deberá permitir gestionar la información relativa a las poblaciones de bacterias asociadas con un experimento. Cada experimento se guardará en un archivo diferente, y cada experimento puede estar compuesto por múltiples poblaciones de bacterias. Para cada población de bacterias, inicialmente el científico indicará: un nombre asociado a esa población, la fecha de comienzo de la población, la fecha de fin de la población, el número de bacterias iniciales, la temperatura a la cual se van a someter las bacterias, las condiciones de luminosidad ("Alta", "Media" y "Baja") y la dosis de comida. Para indicar la dosis de comida, los biólogos deben introducir la cantidad inicial de comida que se le dará el primer día, el día (de entre los 30 días que duran las poblaciones) hasta el cual se debe incrementar la cantidad de comida y la comida de este día, y la cantidad final de comida en el día 30. A partir de estos datos, la aplicación irá calculando la cantidad de comida que hay que proporcionar cada día a las bacterias. Las cantidades de comida son valores enteros menores que 300.

 La aplicación deberá permitir realizar las siguientes acciones:

 1.     Abrir un archivo que contenga un experimento

2.     Crear un nuevo experimento

3.     Crear una población de bacterias y añadirla al experimento actual

4.     Visualizar los nombres de todas las poblaciones de bacterias del experimento actual

5.     Borrar una población de bacterias del experimento actual

6.     Ver información detallada de una población de bacterias del experimento actual

7.     Guardar (se supone que para usar esta opción previamente hemos abierto un archivo)

8.     Guardar como

 

Cuando el usuario seleccione la opción 6, la aplicación deberá solicitar el nombre de la población de la cual quiere ver los detalles, y a continuación deberá mostrarse toda la información detallada del experimento, inclusive la dosis de alimento que se debe dar a las bacterias cada uno de los 30 días.

Necesariamente habrá que guardar en modo texto toda la información correspondiente con cada experimento.
