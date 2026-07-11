package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDAO alumnoDAO=new AlumnoDAO();
    static Alumno alumno=new Alumno();
    static ProfesorDAO profesorDAO = new ProfesorDAO();
    static Profesor profesor = new Profesor();

    private static void registrarProfesor() throws IOException {
        System.out.print("Numero de expediente: ");
        profesor.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());
        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));
        profesorDAO.agregarProfesor(profesor);
    }
    private static void mostrarProfesores() {

        ArrayList<Profesor> listaProfesores = profesorDAO.extraerProfesores();

        System.out.println("------- Lista de Profesores -------");

        if (listaProfesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            for (Profesor p : listaProfesores) {
                System.out.println(p);
                System.out.println("--------------------");
            }
        }
    }
    private static void actualizarProfesor() throws IOException {
        System.out.print("Numero de expediente: ");
        profesor.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());
        System.out.print("Curp: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));
        profesorDAO.actualizar(profesor);

    }

    private static void inscribir() throws IOException{
        System.out.print("Numero de expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("curp: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));
        alumnoDAO.inscribirAlumno(alumno);
    }
    private static void mostrar(){
        ArrayList<Alumno>alumnos=alumnoDAO.extraerAlumnos();
        System.out.println("-------Lista de alumnos------");
        for (Alumno alumno:alumnos){
            System.out.println(alumno);
            System.out.println("--------------------");
        }
    }
    private static void actualizar()throws IOException{
        System.out.print("Numero de expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("Curp: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));
        alumnoDAO.actualizar(alumno);
    }
    private static void darBaja(){}
    private static void buscar(){}
    public static void menu() throws IOException {
        int salir=0;
        while (salir!=9){
            System.out.println("1. Inscribir alumno");
            System.out.println("2. Mostrar alumnos");
            System.out.println("3. Actualizar un alumno");
            System.out.println("4. Dar de baja un alumno");
            System.out.println("5. Buscar alumno");
            System.out.println("6. Registrar profesor");
            System.out.println("7. Mostrar profesores");
            System.out.println("8. Actualizar un profesor");
            System.out.println("9. Salir");
            System.out.println("Elije una opcion: ");
            salir=Integer.parseInt(leer.readLine());
            switch ( salir){
                case 1:inscribir();break;
                case 2:mostrar();break;
                case 3:actualizar();break;
                case 4:darBaja();break;
                case 5:buscar();break;
                case 6:registrarProfesor(); break;
                case 7:mostrarProfesores(); break;
                case 8:actualizarProfesor();break;
                case 9:
                    System.out.println("Haz salido de la aplicacion");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
}
