<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../layout.jsp"></jsp:include>
    <body>
        <div class="col-xs-offset-3 col-xs-6">
            <legend>Editar Usuario</legend>
             <form class="form form-horizontal" method="POST" action="nuevo">
                <div class="form-group">
                    <label class="col-xs-4 control-label" for="nombre_usuario"><b>Nombre de usuario:</b></label>
                    <div class="col-xs-8">
                        <input type="text" id="nombre_usuario" name="nombre_usuario" class="form-control" placeholder="Nombre_usuario" required autofocus>
                    </div>
                </div>
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
                    <label class="col-xs-4 control-label" for="documento"><b>Documento:</b></label>
                    <div class="col-xs-8">
                        <input type="numer" id="documento" name="documento" class="form-control" placeholder="documento" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-4 control-label" for="fecha_nac"><b>Fecha de nacimiento:</b></label>
                    <div class="col-xs-8">
                        <input type="date" id="fecha_nac" name="fecha_nac" class="form-control" placeholder="dd/mm/aaaa" required autofocus>
                    </div>
                </div>
         
                <div class="form-group">
                    <div class="col-xs-offset-4 col-xs-8">
                        <a class="btn btn-primary" href="home">
                            <span class="glyphicon glyphicon-chevron-left"></span> Volver a la pagina principal
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
