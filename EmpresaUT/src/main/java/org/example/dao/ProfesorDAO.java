package org.example.dao;

import org.example.Conexion;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {

    public boolean agregarProfesor(Profesor profesor) {
        boolean inscrito = false;
        String sql = "INSERT INTO profesores VALUES (?, ?, ?, ?, ?)";
        System.out.println(profesor);

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, profesor.getNumExpediente());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getCurp());
            stm.setString(4, profesor.getPuesto());
            stm.setDouble(5, profesor.getSueldo());

            stm.executeUpdate();
            System.out.println("Profesor agregado correctamente");
            inscrito = true;

        } catch (SQLException err) {
            System.out.println("Error al agregar profesor: " + err.getMessage());
        }
        return inscrito;
    }
    public ArrayList<Profesor> extraerProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        String sql = "SELECT * FROM profesores";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setNumExpediente(rs.getInt("numExpediente"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setSueldo(rs.getDouble("sueldo"));

                profesores.add(profesor);
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer a los profesores: " + err.getMessage());
        }
        return profesores;
    }
    public boolean actualizar(Profesor profesor){
        boolean actualizado=false;
        String sql="UPDATE profesores SET nombre= ?,curp= ?, puesto= ?, sueldo= ? WHERE numExpediente= ?";
        try (Connection conexion= Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);){
            stm.setString(1,profesor.getNombre());
            stm.setString(2,profesor.getCurp());
            stm.setString(3,profesor.getPuesto());
            stm.setDouble(4,profesor.getSueldo());
            stm.setInt(5,profesor.getNumExpediente());
            int refiatrosafectados=stm.executeUpdate();
            if(refiatrosafectados>0){
                System.out.println("Profesor actualizado correctamente");
                actualizado=true;
            }
            else {
                System.out.println("El numero de expediente no se encontro");
            }
        }
        catch (SQLException err){
            System.out.println("Error al actulizar al profesor");
        }
        return actualizado;
    }
}