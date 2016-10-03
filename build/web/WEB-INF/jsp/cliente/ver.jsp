<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout.jsp"></jsp:include>
    <body>
    
        <div class="container">
            <h2>Datos del Cliente</h2>
        <c:forEach var="clientes" items="${clientes}">
            <div class="list-group">
                <a href="#" class="list-group-item active">
                    <h4 class="list-group-item-heading">Apellido y Nombre:</h4>
                    <p class="list-group-item-text"><c:out value="${clientes.apellido}, ${clientes.nombre}"/></p>
            </a>
            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Fecha de Nacimiento</h4>
                <p class="list-group-item-text"><c:out value="${clientes.fecha_nac}"/></p>
            </a> 
            
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Documento</h4>
                <p class="list-group-item-text"></p>
            </a> 
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Edad</h4>
                <p class="list-group-item-text"><c:out value="${clientes.edad}"/></p>
            </a> 
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Nacionalidad</h4>
                <c:forEach items="${nacionalidades}" var="nacionalidades" >
                                <c:if test= "${clientes.nacionalidades_id == nacionalidades.id}">
                                    <p class="list-group-item-text"><c:out value="${nacionalidades.descripcion}  ${nacionalidades.iso}"/></p>
                                </c:if>
                            </c:forEach>
                
            </a> 
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Activo</h4>
                <p class="list-group-item-text"><c:out value="${clientes.activo}"/></p>
            </a> 
           
            <div class="form-group">

                <div class="col-xs-offset-4 col-xs-8">
                    <a class="btn btn-primary" href="home">
                        <span class="glyphicon glyphicon-chevron-left"></span> Volver al listado
                    </a>
                    <a class="btn btn-warning pull-right" href="editar?id=${clientes.id}">
                         <span class="glyphicon glyphicon-pencil"></span>Editar cliente
                    </a>
                </div>
            </div>
        </div>
         
    </div>
                    </c:forEach > 
</body>
</html>