package org.example.dao;

import org.example.Conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {
    public boolean inscribirAlumno(Alumno alumno) {
        boolean inscrito=false;
        String sql="INSERT INTO alumnos VALUES (?,?,?,?,?)";
        System.out.println(alumno);
        try(Connection conexion=Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);){
             stm.setInt(1,alumno.getNumExpediente());
             stm.setString(2,alumno.getNombre());
             stm.setString(3,alumno.getCurp());
             stm.setString(4,alumno.getGrupo());
             stm.setDouble(5,alumno.getPromedio());
             stm.executeUpdate();
            System.out.println("Alumno inscrito correctamente");
        }
        catch (SQLException err){
            System.out.println("Error al inscribir alumno"+err.getMessage());
        }
        return inscrito;
    }
    public static ArrayList<Alumno>extraerAlumnos(){
        ArrayList<Alumno> alumnos=new ArrayList<Alumno>();

        String sql="SELECT * FROM alumnos";
        try (Connection conexion=Conexion.conectar();
        PreparedStatement stm=conexion.prepareStatement(sql);){
           ResultSet rs=stm.executeQuery();
           while (rs.next()){
               Alumno alumno=new Alumno();
               alumno.setNumExpediente(rs.getInt("numExpediente"));
               alumno.setNombre(rs.getNString("nombre"));
               alumno.setCurp(rs.getNString("curp"));
               alumno.setGrupo(rs.getNString("grupo"));
               alumno.setPromedio(rs.getDouble("promedio"));
               alumnos.add(alumno);
           }
        }catch ( SQLException err){
            System.out.println("Error al extraer a los alumno "+err.getMessage());
        }
        return alumnos;
    }
    public boolean actualizar(Alumno alumno){
        boolean actualizado=false;
        String sql="UPDATE alumnos SET nombre= ?,curp= ?, grupo= ?, promedio= ? WHERE numExpediente= ?";
        try (Connection conexion= Conexion.conectar();
        PreparedStatement stm = conexion.prepareStatement(sql);){
            stm.setString(1,alumno.getNombre());
            stm.setString(2,alumno.getCurp());
            stm.setString(3,alumno.getGrupo());
            stm.setDouble(4,alumno.getPromedio());
            stm.setInt(5,alumno.getNumExpediente());
            int refiatrosafectados=stm.executeUpdate();
            if(refiatrosafectados>0){
                System.out.println("Alumno actualizado correctamente");
                actualizado=true;
            }
            else {
                System.out.println("El numero de expediente no se encontro");
            }
        }
        catch (SQLException err){
            System.out.println("Error al actulizar al alumno");
        }
        return actualizado;
    }
    public boolean darBajaAlumno(int numExpediente) {
        boolean eliminado = false;
        String sql = "DELETE FROM alumnos WHERE numExpediente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, numExpediente);

            int filasAfectadas = stm.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Alumno dado de baja correctamente.");
                eliminado = true;
            } else {
                System.out.println("No se encontro ningun alumno con ese numero de expediente.");
            }
        } catch (SQLException err) {
            System.out.println("Error al dar de baja al alumno: " + err.getMessage());
        }
        return eliminado;
    }
    public Alumno buscarAlumno(int numExpediente) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE numExpediente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, numExpediente);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setGrupo(rs.getString("grupo"));
                alumno.setPromedio(rs.getDouble("promedio"));
            }
        } catch (SQLException err) {
            System.out.println("Error al buscar alumno: " + err.getMessage());
        }
        return alumno;
    }
}