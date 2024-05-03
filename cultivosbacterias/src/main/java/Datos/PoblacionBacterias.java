package Datos;

import java.util.Date;

public class PoblacionBacterias {
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadInicialBacterias;
    private double temperatura;
    private String condicionesLuz;
    private int dosisInicialAlimento;
    private int dosisFinalAlimento;
    private int incrementarHastaDia;
    private int[] dosisDiariaAlimento;

    public PoblacionBacterias(String nombre, Date fechaInicio, Date fechaFin, int cantidadInicialBacterias, double temperatura, String condicionesLuz, int dosisInicialAlimento, int incrementarHastaDia, int dosisFinalAlimento) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadInicialBacterias = cantidadInicialBacterias;
        this.temperatura = temperatura;
        this.condicionesLuz = condicionesLuz;
        this.dosisInicialAlimento = dosisInicialAlimento;
        this.incrementarHastaDia = incrementarHastaDia;
        this.dosisFinalAlimento = dosisFinalAlimento;
        this.dosisDiariaAlimento = calcularDosisDiariaAlimento();
    }

    private int[] calcularDosisDiariaAlimento() {
        int[] dosisDiariaAlimento = new int[incrementarHastaDia];
        int dosisDiaria = dosisInicialAlimento;
        for (int i = 0; i < incrementarHastaDia; i++) {
            dosisDiariaAlimento[i] = dosisDiaria;
            dosisDiaria += (dosisFinalAlimento - dosisInicialAlimento) / incrementarHastaDia;
        }
        return dosisDiariaAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getCantidadInicialBacterias() {
        return cantidadInicialBacterias;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public String getCondicionesLuz() {
        return condicionesLuz;
    }

    public int getDosisInicialAlimento() {
        return dosisInicialAlimento;
    }

    public int getDosisFinalAlimento() {
        return dosisFinalAlimento;
    }

    public int getIncrementarHastaDia() {
        return incrementarHastaDia;
    }

    public int[] getDosisDiariaAlimento() {
        return dosisDiariaAlimento;
    }
}

