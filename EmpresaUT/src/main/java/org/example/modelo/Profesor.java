package org.example.modelo;

import org.example.Ensenador;
import org.example.Evaluador;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {
    private int numExpediente;
    private String puesto;
    private double sueldo;

    public Profesor(){}

    public Profesor(int numExpediente, String nombre, String curp, String puesto, double sueldo) {
        super(nombre, curp);
        setNumExpediente(numExpediente);
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    public int getNumExpediente() {return numExpediente;}

    public void setNumExpediente(int numExpediente) {
        if (numExpediente>2000000000 && numExpediente<2140000000){
            this.numExpediente = numExpediente;
        } else {
            System.out.println("Numero de expediente no valido");
        }
    }

    public String getPuesto() {return puesto.toUpperCase();}

    public void setPuesto(String puesto) {
        if (puesto.isEmpty()||puesto.isBlank()){
            System.out.println("El puesto es requerido");
        }
        else{
            this.puesto = puesto;
        }
    }

    public double getSueldo() {
        String sueldoForma=String.format("%1f",this.sueldo);
        return Double.parseDouble(sueldoForma);
    }

    public void setSueldo(double sueldo) {
        if (sueldo>0){
            this.sueldo = sueldo;
        }
        else{
            System.out.println("El sueldo tiene que ser mayor a 0");
        }
    }
    @Override
    public  String mostrarTipoPersona(){
        return "-----PROFESOR-----";
    }

    @Override
    public String toString() {
        return mostrarTipoPersona()+"\n"+
                "Numero de expediente: " + getNumExpediente() + "\n" +
                super.toString() +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: " + getSueldo() + "\n"+
                "-------------------------------------------\n";
    }
    @Override
    public void ensenar() {
        System.out.println("El profesor " + this.getNombre() + " está impartiendo su clase.");
    }
    @Override
    public void evaluar(Alumno alumno, double calificacion) {
        System.out.println("El profesor " + this.getNombre() + " está evaluando al alumno " + alumno.getNombre());
        alumno.recibirEvaluacion(calificacion);
    }
}
