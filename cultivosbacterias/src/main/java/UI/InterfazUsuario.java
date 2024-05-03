package UI;

import Logica.Experimento;
import Datos.Archivos;
import Datos.PoblacionBacterias;

import java.util.Scanner;

public class InterfazUsuario {
    private Experimento experimento;
    private Archivos archivos;

    public InterfazUsuario() {
        experimento = new Experimento();
        archivos = new Archivos();
    }

    public void mostrarMenu() {
        System.out.println("1. Abrir un archivo que contenga un experimento");
        System.out.println("2. Crear un nuevo experimento");
        System.out.println("3. Crear una población de bacterias y añadirla al experimento actual");
        System.out.println("4. Visualizar los nombres de todas las poblaciones de bacterias del experimento actual");
        System.out.println("5. Borrar una población de bacterias del experimento actual");
        System.out.println("6. Ver información detallada de una población de bacterias del experimento actual");
        System.out.println("7. Guardar");
        System.out.println("8. Guardar como");
        System.out.println("9. Salir");
    }

    public void ejecutarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                // Implementar lógica para abrir un archivo
                break;
            case 2:
                // Implementar lógica para crear un nuevo experimento
                break;
            case 3:
                // Implementar lógica para crear una nueva población de bacterias
                break;
            case 4:
                // Implementar lógica para visualizar los nombres de todas las poblaciones de bacterias
                break;
            case 5:
                // Implementar lógica para borrar una población de bacterias
                break;
            case 6:
                // Implementar lógica para ver información detallada de una población de bacterias
                break;
            case 7:
                // Implementar lógica para guardar
                break;
            case 8:
                // Implementar lógica para guardar como
                break;
            case 9:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                break;
        }
    }
}