<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../layout.jsp"></jsp:include>

    <body>
        <div class="col-xs-offset-3 col-xs-6">
            <legend>Nuevo cliente</legend>
            <form class="form form-horizontal" method="POST" action="nuevo">
                <div class="form-group">
                    <label class="col-xs-4 control-label" for="nombre"><b>Nombre:</b></label>
                    <div class="col-xs-8">
                        <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-4 control-label" for="apellido"><b>Apellido:</b></label>
                    <div class="col-xs-8">
                        <input type="text" id="apellido" name="apellido" class="form-control" placeholder="Apellido" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-4 control-label" for="documento"><b>Documento de identidad:</b></label>
                    <div class="col-xs-8">
                        <input type="num" id="documento" name="documento" maxlength="9" min="6" class="form-control" placeholder="Ingrese su documento"  required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-4 control-label" for="fecha_nac"><b>Fecha de nacimiento:</b></label>
                    <div class="col-xs-8">
                        <input type="date" id="fecha_nac" name="fecha_nac" class="form-control" placeholder="dd/mm/aaaa" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nacionalidad" class="col-xs-4 control-label">Nacionalidad:</label>
                    <div class="col-xs-8">
                        
                        <select class="form-control" id="nacionalidad" name="nacionalidad" required>
                            <option>Elige un Pais</option>
                            <c:forEach items="${nacionalidades}" var="nacionalidades" >
                                <option value="<c:out value="${nacionalidades.id}"/>"> <c:out value="${nacionalidades.descripcion}  ${nacionalidades.iso}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-4 col-xs-8">
                        <a class="btn btn-primary" href="home">
                            <span class="glyphicon glyphicon-chevron-left"></span> Volver al listado
                        </a>
                        <button type="submit" class="btn btn-success pull-right">
                            Guardar <span class="glyphicon glyphicon-save-file"></span>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
