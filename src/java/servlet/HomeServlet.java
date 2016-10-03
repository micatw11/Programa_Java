/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.Clientes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            response.setContentType("text/html;charset=UTF-8");
            
            List <HashMap<String, Object>> resultado =null;
            resultado= Clientes.ClientesListado();
            request.setAttribute("resultado", resultado);

            request.setAttribute("title", "Listado de clientes");

            request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
            
        } catch (NamingException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
