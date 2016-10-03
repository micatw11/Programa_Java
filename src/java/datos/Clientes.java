/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Clientes {
    
    private int id;
    private static String apellido;
    private static String nombre;
    private static int documento;
    private static Date fecha_nacimiento;
    private static int edad;
    private static int nacionalidad;
    private static int activo;

    public Clientes() {
        this.id = 0;
        this.apellido = null;
        this.nombre = null;
        this.fecha_nacimiento = null;
        this.edad = 0;
        this.nacionalidad = 0;
        this.activo = 0;
    }
    
    
    public static boolean insert(){
            Connection conn = null;
        try {
            conn = Conexion.getConnection();

            StringBuilder query = new StringBuilder();
            
            
            query.append("INSERT INTO Base_Datos.persona_cliente ");
            query.append("     (nombre, apellido,documento,activo,nacionalidades_id, fecha_nac, edad) ");
            query.append("VALUES ( ?, ?, ?, ?, ?,?,?)");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, documento);
            pstmt.setDate(6, fecha_nacimiento);
            pstmt.setInt(4, activo);
            pstmt.setInt(5, nacionalidad);
            pstmt.setInt(7, edad);
            pstmt.execute();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.print("Error al conectar"+conn);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    
    
    public static List<HashMap<String, Object>> ClienteId(int id) {
        Connection conn = null;
        ResultSet rs=null;
        List<HashMap<String, Object>> result=null;
        try {
         conn = Conexion.getConnection();
            
            String sql;
            sql = "SELECT * FROM persona_cliente WHERE (id = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            result = new LinkedList();
            while(rs.next()){
                        HashMap row = new HashMap();
                        row.put("id", rs.getInt("id"));
                        row.put("nombre", rs.getString("nombre"));
                        row.put("apellido", rs.getString("apellido"));
                        row.put("edad", rs.getInt("edad"));
                        row.put("documento", rs.getInt("documento"));
                        row.put("fecha_nac", rs.getDate("fecha_nac"));
                        row.put("activo", rs.getInt("activo"));
                        row.put("nacionalidades_id", rs.getInt("nacionalidades_id"));
                        result.add(row);
            }
             } catch (NamingException | SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public static List<HashMap<String, Object>> ClientesListado() throws NamingException {
        List <HashMap<String, Object>> resultado=null;
        try {
            Connection conn = Conexion.getConnection();
            
            String sql = "SELECT * FROM Base_Datos.persona_cliente";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

           resultado = new LinkedList();
            
                    while(rs.next()){
                        HashMap row = new HashMap();
                        row.put("id", rs.getInt("id"));
                        row.put("nombre", rs.getString("nombre"));
                        row.put("apellido", rs.getString("apellido"));
                        row.put("documento", rs.getInt("documento"));
                        row.put("fecha_nac", rs.getDate("fecha_nac"));
                        row.put("activo", rs.getInt("activo"));
                        resultado.add(row);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
     public static boolean actualizar(int id) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("UPDATE persona_cliente ");
            query.append("SET apellido =  ? , ");
            query.append("nombre =  ?, ");
            query.append("documento =  ?, ");
            query.append("fecha_nac = ?, ");
            query.append("edad = ?, ");
            query.append("activo = ?, ");
            query.append("nacionalidades_id = ? ");
            query.append("WHERE ");
            query.append("clientes.id = ?");
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, apellido);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, documento);
            pstmt.setDate(4, fecha_nacimiento);
            pstmt.setInt(5, edad);
            pstmt.setInt(7, nacionalidad);
            pstmt.setInt(6, activo);
            pstmt.setInt(8, id);

            pstmt.execute();
            } catch (SQLException | NamingException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return true;
    }

    //elimina un cliente de la base de datos
    public static boolean eliminar(int id) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM ");
            query.append("persona_cliente ");
            query.append("WHERE id = ?");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(1, id);

            pstmt.execute();

            } catch (SQLException | NamingException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return true;
    }

    public static int getDocumento() {
        return documento;
    }

    public static void setDocumento(int documento) {
        Clientes.documento = documento;
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
    public void setEdad(Date fecha_nac) { //fecha_nac debe tener el formato dd/MM/yyyy
         java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        String fecha_naci = formato.format(fecha_nac);
        String[] dat1 = fecha_naci.split("/");
        String[] dat2 = hoy.split("/");
        int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            anos = anos - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            
            if (dia < 0) {
                anos = anos - 1;
            }
        }
        this.edad =anos;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
            java.util.Date dateStr = formatter.parse(fecha_nacimiento);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            setEdad(dateDB);
            this.fecha_nacimiento = dateDB;
        } catch (ParseException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    
    public String toString() {
        return "Clientes{" + "id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", activo=" + activo + '}';
    }

  
    
}

