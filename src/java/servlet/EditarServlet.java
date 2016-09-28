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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author universidad
 */
@WebServlet(name = "EditarServlet", urlPatterns = {"/EditarServlet"})
public class EditarServlet extends HttpServlet {

   
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            response.setContentType("text/html;charset=UTF-8");
            
            Integer id = Integer.valueOf(request.getParameter("id"));
            
            Connection conn = Conexion.getConnection();
            
            String sql;
            sql = "SELECT * FROM clientes_db.clientes WHERE (id = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();        

            request.setAttribute("resultado", rs);
            
            request.setAttribute("title", "Cliente " + id);

            request.getRequestDispatcher("WEB-INF/jsp/cliente/editar.jsp").forward(request, response);
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//     
//response.setContentType("text/html;charset=UTF-8");
//        HashMap<String, Object> errores = new HashMap();
//        
//        String miNombre;
//        Integer miEdad;
//        String pais;
//        
//        miNombre = request.getParameter("nombre");
//        try {
//            miEdad = Integer.valueOf(request.getParameter("edad"));
//        } catch (NumberFormatException e){
//            errores.put("edad","La edad no es valida");
//            miEdad = null;
//        }
//        pais = request.getParameter("Pais");
//        
//        // poner variable a disposicion de jsp
//        //request.setAttribute("nombre", miNombre);
//        if (miNombre == null || miNombre.length() == 0) {
//            errores.put("nombre","El nombre no puede ser vacio");
//        }        
//        if(pais.equals("0")){
//            errores.put("localidad","el pais es requerida");
//        }
//        
//        if (errores.isEmpty()) {
//            request.setAttribute("nombre", miNombre);
//            request.setAttribute("edad", miEdad);
//            request.setAttribute("localidad", pais);
//            request.getRequestDispatcher("datos_ok.jsp").forward(request, response);
//        } else {
//            request.setAttribute("errores", errores);
//            request.getRequestDispatcher("form.jsp").forward(request, response);
//        }
//        //Redirije jsp
//        //request.getRequestDispatcher("hola.jsp").forward(request, response);
//    }
//}