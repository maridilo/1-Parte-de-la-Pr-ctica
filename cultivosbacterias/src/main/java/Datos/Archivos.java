package Datos;

import Logica.Experimento;
import java.io.*;
import java.util.ArrayList;

public class Archivos {

    public Experimento abrirArchivo(String nombreArchivo) {
        // Implementar lógica para abrir un archivo y leer los datos del experimento
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Experimento experimento = (Experimento) objectInputStream.readObject();
            objectInputStream.close();
            return new Experimento();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
             }
        }

    public void guardarArchivo(String nombreArchivo, ArrayList<PoblacionBacterias> poblaciones) {
        // Implementar lógica para guardar las poblaciones de bacterias en un archivo
    }

    public void guardarComoArchivo(String nombreArchivo, ArrayList<PoblacionBacterias> poblaciones) {
        // Implementar lógica para guardar las poblaciones de bacterias en un nuevo archivo
    }
}
