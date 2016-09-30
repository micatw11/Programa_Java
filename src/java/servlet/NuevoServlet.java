/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Clientes;
import java.util.Calendar;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 *
 * @author universidad
 */
@WebServlet(name = "NuevoServlet", urlPatterns = {"/nuevo"})
public class NuevoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            response.setContentType("text/html;charset=UTF-8");

            Connection conn = Conexion.getConnection();

            String sql = "SELECT * FROM clientes_db.nacionalidades";
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

            request.setAttribute("nacionalidades", nacionalidades);

            request.setAttribute("title", "Nuevo cliente");
           
            request.getRequestDispatcher("WEB-INF/jsp/cliente/nuevo.jsp").forward(request, response);
           
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Connection conn =null;
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            Clientes clientes = new Clientes();
            String nombre = (String) request.getParameter("nombre");
            clientes.setNombre(nombre);
            String apellido = (String) request.getParameter("apellido");
            clientes.setApellido(apellido);
            String fecha_nacimiento = (String) request.getParameter("fecha_nac");
            clientes.setFecha_nacimiento(fecha_nacimiento);
            int nacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
            clientes.setNacionalidad(nacionalidad);
            int activo = Integer.parseInt(request.getParameter("activo"));
            clientes.setActivo(activo);
            
//            java.util.Date date = new java.util.Date();
//             java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
//            java.util.Date fecha = null;
//            try {
//                fecha = formatter.parse(fecha_nacimiento);
//            } catch (ParseException ex) {
//                Logger.getLogger(NuevoServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Date fechaEvento = new Date(); //se crea e inicializa un objeto de tipo Date
//            Calendar c; //Se crea un objeto de tipo calendar
//           // String fecha2; //la cadena en la que se guardará la fecha
//            /*Este proceso, es en realidad el while de la consulta que se realiza a la base de datos, para entenderlo mejor, descargar el ejemplo completo. Pero básicamente lo que se hace es, obtener la fecha en formato String, convertirla a long y asignarla al objeto tipo Date, usando el método setTime, el cual recibe un long*/
//            fechaEvento.setTime(Long.parseLong(temp.getFecha_evento()));
//            c = Calendar.getInstance(); //se obtiene una instancia de calendar, con la fecha actual.
//            c.setTime(fechaEvento); //se le asigna a calendar la fecha obtenida de la base de datos.
//            /*Se asigna a la cadena el formato deseado manualmente, este formato también se puede obtener de manaera más fácil con getdateformat, pero quise hacerlo de este modo*/
//            fecha2 = Integer.toString(c.get(Calendar.DATE))+"/"+
//            Integer.toString(c.get(Calendar.MONTH))+ "/"+Integer.toString(c.get(Calendar.YEAR));
////            // 
//            java.text.SimpleDateFormat formatoDelTexto = new java.text.SimpleDateFormat("dd-MM-yyyy");
//            
//            //String fecha2;
//            fecha2 = formatoDelTexto.format(fecha);
//            clientes.setFecha_nacimiento(fecha2);
//            int edad = edad(fecha);
//            System.out.println("set fecha que llega "+fecha+ " edad ="+edad);
                   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = null;
                try {
                    fecha = formatter.parse(fecha_nacimiento);
                } catch (ParseException ex) {
                    Logger.getLogger(NuevoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            // System.out.println("set fecha que llega "+fecha);
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            
            String fecha2 = formatoDelTexto.format(fecha);
            
            
//            Date fecha_nac = null;
//           
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                fecha_nac = df.parse(fecha_nacimiento);
//            } catch (Exception e) {
//
//                Logger.getLogger(NuevoServlet.class.getName()).log(Level.SEVERE, null, e);
//            }
//            
//             String fechadb= df.format(fecha_nac);
clientes.setFecha_nacimiento(fecha2);

// SimpleDateFormat fecha_edad = new SimpleDateFormat("dd/MM/yyyy");
int edad = edad(fecha);
            
             clientes.setEdad(edad);
            
            Date fecha_nac = null;

           
           // out.println("fecha "+ fecha_nac +" fecha2 "+fecha_nac2 +" fecha2 "+fecha2);
            Context initContext = new InitialContext(); 
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
             
            conn = ds.getConnection();
          
           // Connection conn = Conexion.getConnection();
            
            String sql = "INSERT INTO 'clientes' "
                    + "(apellido,"
                    + "nombre,"
                    + "documento,"
                   + "fecha_nac,"
                    + "edad," 
                    + "activo) "
                    + "nacionalidades_id,"
                    + "VALUES(?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?)";
       
//            StringBuilder query = new StringBuilder();

//            query.append("INSERT INTO clientes ");
//            query.append("     (apellido, nombre, fecha_nac, edad, nacionalidades_id, activo) ");
//            query.append("VALUES ( ?, ?, ? , ? , ? , 1 )");
////            
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, clientes.getApellido());
//            pstmt.setString(2, clientes.getNombre());
//            pstmt.setInt(3, clientes.getActivo());
//            pstmt.setString(4, clientes.getFecha_nacimiento());
//            pstmt.setInt(5, clientes.getEdad());
//            pstmt.setInt(6, clientes.getActivo());
//            pstmt.setInt(7, clientes.getNacionalidad());
//              pstmt.setString(1, apellido2);
//            pstmt.setString(2, nombre2);
//          //pstmt.setInt(3, documento2);
//         pstmt.setString(3,  fecha_nac2);
//            pstmt.setInt(4, edad2);
//            pstmt.setInt(5, activo2);
//            pstmt.setInt(6, nacionalidad_id2);
//           out.println("apellido nombre"+clientes.getApellido()+clientes.getNombre()+"activo y documento"
//                    +clientes.getActivo()+"fecha"+ clientes.getFecha_nacimiento() + "edad"+ clientes.getEdad()+"nacionalidad"+clientes.getNacionalidad());
//            out.println("apellido "+apellido2+"nombre"+nombre+"activo y documento"
//                    +activo2+"fecha"+ fecha_nac2 + 
//                     "edad"+ edad2+"nacionalidad"+nacionalidad_id2);

            pstmt.execute();  
            //out.println("entreee");
            request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(NuevoServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ex.getMessage());
        }
    }

    public int edad(Date fecha_naci) {     //fecha_nac debe tener el formato dd/MM/yyyy
        
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        String fecha_nac = formato.format(fecha_naci);
        String[] dat1 = fecha_nac.split("/");
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
        return anos;
    }
}
