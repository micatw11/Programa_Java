/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.Clientes;
import datos.Nacionalidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 *
 * @author universidad
 */
@WebServlet(name = "EditarServlet", urlPatterns = {"/EditarServlet"})
public class EditarServlet extends HttpServlet {

  
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    int id = Integer.parseInt(request.getParameter("id"));
    Clientes datos= new Clientes();
    datos.setId(id);
    List<HashMap<String, Object>> clientes=Clientes.ClienteId(id);
    List<HashMap<String, Object>> nacionalidades= null;
     nacionalidades = Nacionalidades.verListado();
    
    request.setAttribute("clientes", clientes );
    request.setAttribute("nacionalidades", nacionalidades);
    request.setAttribute("title", "Editar Cliente ");
    request.getRequestDispatcher("WEB-INF/jsp/cliente/editar.jsp").forward(request, response);
    }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
      response.setContentType("text/html;charset=UTF-8");
      Clientes clientes = new Clientes();
      String nombre = request.getParameter("nombre");
      clientes.setNombre(nombre);
      String apellido = request.getParameter("apellido");
      clientes.setApellido(apellido);
      String fecha_nacimiento = request.getParameter("fecha_nac");
      clientes.setFecha_nacimiento(fecha_nacimiento);
      int nacionalidad = Integer.parseInt(request.getParameter("nacionalidades"));
      clientes.setNacionalidad(nacionalidad);
      int activo = Integer.parseInt(request.getParameter("activo"));
      
      clientes.setActivo(activo);
     
      Clientes.actualizar(clientes.getId());
      response.sendRedirect("home");
    }
}