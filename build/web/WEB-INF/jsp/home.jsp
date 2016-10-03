<h3>Clientes</h3>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="layout.jsp"></jsp:include>
    <body>
        <div class="container">
            <div class="col-xs-offset-3 col-xs-6 ">
                <table class="table table-responsive table-striped table-hover table-condensed">
                   
                    <tbody>
                        <tr>
                            <th>
                                Nombre</th>
                            <th>
                                Apellido</th>
                            <th>
                                Edad </th>
                            <th>
                                Acciones
                            </th>
                        </tr>
                        <c:forEach var="clientes" items="${resultado}">
                            <tr>
                                <td>
                                    ${clientes.nombre}</td>
                                <td>
                                    ${clientes.apellido}</td>
                                <td>
                                    ${clientes.fecha_nac}</td>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-info" href="ver?id=${clientes.id}"><span class="glyphicon glyphicon-eye-open"></span> Ver</a>
                                        <a class="btn btn-primary" href="editar?id=${clientes.id}"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
                                        <a button class="btn btn-danger" href="javascript:;" onclick="aviso('borrar?id=${clientes.id}'); return false;" ><span class="glyphicon glyphicon-trash"></span> Eliminar</a>
                                    </div>                                    
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <hr>
                <a class="btn btn-success pull-right" href="nuevo"><span class="glyphicon glyphicon-plus"></span> Nuevo cliente</a>
            </div>
        </div>
    </body>
</html>
