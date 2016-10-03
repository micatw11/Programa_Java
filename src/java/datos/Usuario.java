/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Usuario {
    private int id;
    private String nombre_usuario;
    private String apellido;
    private String nombre;
    private int documento;
    private int edad;
    private int activo;
    
    
    public static Usuario getUsuario(String user, String password) {
        Usuario usr = null;
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/Base_Datos");
            conn = ds.getConnection();
            StringBuilder query = new StringBuilder();

            //busca el usuario con su respectiva contraseña en la base de datos 
            query.append("SELECT usuarios.id, usuarios.nombre_usuario ");
            query.append("FROM Base_Datos.usuarios ");
            query.append("WHERE");
            query.append("usuarios.nombre_usuario LIKE ? ");
            query.append("     AND usuarios.password = SHA1( ? ) ");
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, user);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                usr = new Usuario(rs.getInt("id"), rs.getString("nombre"));
            }
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usr;
    }

    public Usuario(int id, String nombre_usuario) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
    }
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
     public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
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
    public int getDocumento() {
        return documento;
    }
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getActivo() {
        return activo;
    }
    public void setActivo(int activo) {
        this.activo = activo;
    }
     
}
