/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author haymica
 */
public class Clientes {
    private int id;
    private String apellido;
    private String nombre;
    private String fecha_nacimiento;
    private int edad;
    private int nacionalidad;
    private int activo;

    public Clientes() {
        this.id = 0;
        this.apellido = null;
        this.nombre = null;
        this.fecha_nacimiento = null;
        this.edad = 0;
        this.nacionalidad = 0;
        this.activo = 0;
    }
    
    
    public static boolean insert(String nombre, String apellido) {
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");

            conn = ds.getConnection();

            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO nacionalidades ");
            query.append("     (descripcion, iso) ");
            query.append("VALUES ( ?, ?)");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
//            pstmt.setString(3, fecha_nacimiento);
//            pstmt.setInt(4, nacionalidad);
System.out.println("execute");
            pstmt.execute();
            System.out.println("paseee");
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public int getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public int getActivo() {
        return activo;
    }
    public void setActivo(int activo) {
        this.activo = activo;
    }
}

