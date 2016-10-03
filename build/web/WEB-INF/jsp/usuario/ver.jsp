<jsp:include page="../layout.jsp"></jsp:include>
    <body>

        <div class="container">
            <h2>Datos del Usuario</h2>
            <div class="list-group">
                <a href="#" class="list-group-item active">
                    <h4 class="list-group-item-heading">Nombre de Usuario:</h4>
                    <p class="list-group-item-text"><c:out value="${usuario.getApellido}", "${usuario.getNombre}"/></p>
            </a>
                <a href="#" class="list-group-item active">
                    <h4 class="list-group-item-heading">Apellido y Nombre:</h4>
                    <p class="list-group-item-text"><c:out value="${usuario.getApellido}", "${usuario.getNombre}"/></p>
            </a>
            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Fecha de Nacimiento</h4>
                <p class="list-group-item-text"><c:out value="${usuario.getFechaNacimiento}"/></p>
            </a> 
            
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Documento</h4>
                <p class="list-group-item-text"><c:out value="${usuario.getDocumento}"/></p>
            </a> 
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Edad</h4>
                <p class="list-group-item-text"><c:out value="${usuario.getEdad}"/></p>
            </a> 
  
           
            <div class="form-group">

                <div class="col-xs-offset-4 col-xs-8">
                    <a class="btn btn-primary" href="home">
                        <span class="glyphicon glyphicon-chevron-left"></span> Volver al listado
                    </a>
                    <a class="btn btn-warning pull-right" href="editar?id=${usuario.id}">
                        Editar cliente <span class="glyphicon glyphicon-pencil"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>





</form>
</div>
</body>
</html>
