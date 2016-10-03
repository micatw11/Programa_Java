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
import servlet.Conexion;
import datos.Nacionalidades;
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

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        List<HashMap<String, Object>> nacionalidades= null;
        nacionalidades=Nacionalidades.verListado();
        request.setAttribute("nacionalidades", nacionalidades);
        request.setAttribute("title", "Nuevo cliente");
        request.getRequestDispatcher("WEB-INF/jsp/cliente/nuevo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Connection conn =null;
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            Clientes clientes = new Clientes();
            String nombre = request.getParameter("nombre");
            clientes.setNombre(nombre);
            String apellido = request.getParameter("apellido");
            clientes.setApellido(apellido);
            int documento = Integer.parseInt(request.getParameter("documento"));
            clientes.setDocumento(documento);
            String fecha_nacimiento = request.getParameter("fecha_nac");
            clientes.setFecha_nacimiento(fecha_nacimiento);
            int nacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
            clientes.setNacionalidad(nacionalidad);
            clientes.setActivo(1);
            Clientes.insert();
        response.sendRedirect("home");
    }
   
}
