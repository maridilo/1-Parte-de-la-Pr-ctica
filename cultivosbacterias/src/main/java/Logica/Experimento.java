package Logica;

import Datos.PoblacionBacterias;
import java.util.ArrayList;

public class Experimento {
    private ArrayList<PoblacionBacterias> poblaciones;

    // Implementar lógica para el constructor
    public Experimento() {
        poblaciones = new ArrayList<>();
    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
        // Implementar lógica para agregar una población de bacterias

        poblaciones.add(poblacion);
    }

    public void eliminarPoblacion(String nombre) {
        // Implementar lógica para eliminar una población de bacterias

        for (int i = 0; i < poblaciones.size(); i++) {
            if (poblaciones.get(i).getNombre().equals(nombre)) {
                poblaciones.remove(i);
                break;
            }
        }
    }

    public void editarPoblacion(String nombre, PoblacionBacterias nuevaPoblacion) {
    for (int i = 0; i < poblaciones.size(); i++) {
        if (poblaciones.get(i).getNombre().equals(nombre)) {
            poblaciones.set(i, nuevaPoblacion);
            break;
        }
    }
}

    public PoblacionBacterias obtenerPoblacion(String nombre) {
        // Implementar lógica para obtener una población de bacterias

        for (PoblacionBacterias poblacion : poblaciones) {
            if (poblacion.getNombre().equals(nombre)) {
                return poblacion;
            }
        }
        return null;
    }

    public ArrayList<PoblacionBacterias> obtenerPoblaciones() {
        // Implementar lógica para obtener todas las poblaciones de bacterias

        return poblaciones;
    }
}