package org.example.modelo;

import org.example.Ensenable;
import org.example.Evaluable;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {
    private int numExpediente;
    private String grupo;
    private double promedio;

    public Alumno() {}

    public Alumno(int numExpedinente, String nombre, String curp, String grupo, double promedio) {
        super(nombre, curp);
        setNumExpediente(numExpediente);
        setGrupo(grupo);
        setPromedio(promedio);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        if (numExpediente>2000000000 && numExpediente<2140000000){
            this.numExpediente = numExpediente;
        } else {
            System.out.println("Numero de expediente no valido");
        }
    }
    public String getGrupo() {
        return grupo.toUpperCase();
    }

    public void setGrupo(String grupo) {
        if (grupo.isEmpty()|| grupo.isBlank()){
            System.out.println("El grupo es requerido");
        }
        else{
            this.grupo = grupo;
        }
    }

    public double getPromedio() {
        String promedioForma=String.format("%1f",this.promedio);
        return Double.parseDouble(promedioForma);
    }

    public void setPromedio(double promedio) {
        if(promedio>=0&& promedio<=10){
            this.promedio = promedio;
        }
        else {
            System.out.println("El promedio debe ser entre 0 y 10");
        }
    }
    @Override
    public  String mostrarTipoPersona(){
        return "-----ALUMNO-----";
    }
    @Override
    public String toString(){
        return  mostrarTipoPersona()+"\n"+
                "Numero de expediente: "+getNumExpediente()+"\n"+
                super.toString()+
                "Grupo: "+getGrupo()+"\n"+
                "Promedio: "+getPromedio()+"\n"+
                "-------------------------------------------\n";
    }
    @Override
    public void aprender() {
        System.out.println("El alumno " + this.getNombre() + " esta aprendiendo.");
    }
    @Override
    public void recibirEvaluacion(double calificacion) {
        System.out.println("El alumno " + this.getNombre() + " recibio una calificacion de: " + calificacion);
    }
}
