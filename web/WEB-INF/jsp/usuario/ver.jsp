<jsp:include page="../layout.jsp"></jsp:include>
    <body>

        <div class="container">
            <h2>Datos del Cliente</h2>
            <div class="list-group">
                <a href="#" class="list-group-item active">
                    <h4 class="list-group-item-heading">Apellido y Nombre:</h4>
                    <p class="list-group-item-text"><c:out value="${clientes.getApellido}", "${clientes.getNombre}"/></p>
            </a>
            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Fecha de Nacimiento</h4>
                <p class="list-group-item-text"><c:out value="${clientes.getFechaNacimiento}"/></p>
            </a> 
            
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Documento</h4>
                <p class="list-group-item-text"><c:out value="${clientes.getDocumento}"/></p>
            </a> 
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Edad</h4>
                <p class="list-group-item-text"><c:out value="${clientes.getEdad}"/></p>
            </a> 
             <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Activo</h4>
                <p class="list-group-item-text"><c:out value="${clientes.getActivo}"/></p>
            </a> 
           
            <div class="form-group">

                <div class="col-xs-offset-4 col-xs-8">
                    <a class="btn btn-primary" href="home">
                        <span class="glyphicon glyphicon-chevron-left"></span> Volver al listado
                    </a>
                    <a class="btn btn-warning pull-right" href="editar?id=${clientes.id}">
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
