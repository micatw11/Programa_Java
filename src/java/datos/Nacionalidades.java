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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import servlet.Conexion;

/**
 *
 * @author haymica
 */
public class Nacionalidades {
    private int id;
    private String nombre;
    private String iso;

    public Nacionalidades(int id, String nombre, String iso) {
        this.id = id;
        this.nombre = nombre;
        this.iso = iso;
    }
    
   @SuppressWarnings("unchecked")
   public static List<HashMap<String, Object>> verListado() {
        try {
            Connection conn = Conexion.getConnection();
            
            String sql = "SELECT * FROM Base_Datos.nacionalidades";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<HashMap<String, Object>> nacionalidades = new LinkedList();

            while (rs.next()) {
                
                    HashMap row = new HashMap();
                    row.put("id", rs.getInt("id"));
                    row.put("descripcion", rs.getString("descripcion"));
                    row.put("iso", rs.getString("iso"));
                    nacionalidades.add(row);
              
            } 
            return nacionalidades;
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Nacionalidades.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
   }
            
            
}
