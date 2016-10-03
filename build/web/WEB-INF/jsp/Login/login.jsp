<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
    </head>
    <body>
       <div id="login">
           <form id="login2" action="login" method="post"> 
               <ul> 
                   <li> Nombre Usuario:
                       <input id="username" name="username" placeholder="Ingrese nombre usuario" title="Email" type="text" value="" size="40"/> 
                   </li> 
               </ul> 
               <ul> 
                   <li> Contraseña: 
                       <input id="password" name="password" placeholder="Ingrese Contraseña" title="Password" type="password" value="" size="25" min="8"/> 
                       <input id="submit" name="submit" type="submit" value="Login"> 
                   </li> 
               </ul> 
               <ul> 
                   <input type="hidden" value="login" name="accion"/> 
               </ul> 
           </form> 
       </div> 
        <br><b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
    </body>
</html>
