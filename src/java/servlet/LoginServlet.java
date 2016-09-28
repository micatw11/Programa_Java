/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author haymica
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usr = request.getParameter("usuario");
        String pass = request.getParameter("pass");
//valida datos

//buscar el usuario en la base
        Usuario user = getUsuarioBD(usr, pass);

        if (user != null) {
            HttpSession session = request.getSession();//recupero sesion o crea una nueva
            session.setAttribute("esta_logueado", true);
            session.setAttribute("usuario", user);//implements serial
//redirect al servlet/jsp protegido
}else{ 
//….forware al form de login
}
}

protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession session = request.getSession();
        session.invalidate();
        //redirect al servltet/jsp publico
    }

    protected void control(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
    HttpSession session= request.getSession(false); // traigo la session actual,
Boolean esta_logueado = (Boolean) session.getAttribute("esta_logueado");
    if (session != null && esta_logueado){
    Usuario user = (Usuario) session.getAttribute("usuario");  //des-serial
} //else {

    }

 

  
    private Usuario getUsuarioBD(String usr, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
//		IOException {
//		
//		if("login".equals(request.getParameter("accion"))){
//			// Logueo del usuario
//			if(request.getSession().getAttribute("user")!=null){
//				RequestDispatcher a=request.getRequestDispatcher("index.jsp");
//				a.forward(request, response);
//			}
//			login(request, response);
//		}
//		// ....
//	}
//	
//	void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		if(request.getParameter("username")!=null && request.getParameter("password").equals(usuarioLogin.getContrasenia())){
//			if(request.getParameter("username").equals("NombreDeUnUsuario"){
//				HttpSession session = request.getSession();
//				session.setAttribute("user", request.getParameter("username"));
//				RequestDispatcher a = request.getRequestDispatcher("index.jsp");
//				a.forward(request, response);
//			}
//			RequestDispatcher a = request.getRequestDispatcher("login.jsp?msg=Usuario y/o " +
//				"contraseña incorrectos");
//			a.forward(request, response);
//		}
//		RequestDispatcher a = request.getRequestDispatcher("login.jsp?msg=Usuario y/o contraseña incorrectos");
//		a.forward(request, response);
//	}

}

   
