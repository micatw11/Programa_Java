/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import java.lang.NullPointerException;


@WebServlet(name = "VerServlet", urlPatterns = {"/ver"})
public class VerServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<HashMap<String, Object>> clientes;
       int id = Integer.parseInt(request.getParameter("id"));
        clientes = Clientes.ClienteId(id);
        request.setAttribute("clientes", clientes);
         request.setAttribute("title", "ver cliente");
        request.getRequestDispatcher("WEB-INF/jsp/cliente/ver.jsp").forward(request, response);
    }
}
