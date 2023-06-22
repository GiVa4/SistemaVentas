<%-- 
    Document   : index
    Created on : 12 jun 2023, 10:49:34
    Author     : MarckTK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Login del Sistema</title>
        <!-- Enlace del Icono -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/icono.png" />
        <!-- Enlace con Css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="${pageContext.request.contextPath}/login" method="post">
                        <div class="form-group text-center">
                            <h3>Iniciar Seción</h3>
                            <img src="img/logo.png" alt="" class="img-logo"/>
                            <label>Bienvenido al Sistema</label>
                        </div>
                        <div class="form-group">
                            <label for="txtUser" class="form-label" style="margin-left: 0px">Usuario: </label>
                            <input type="text" id="txtUser" class="form-control" placeholder="EmpExample" name="txtUser">
                        </div>
                        <div class="form-group">
                            <label for="txtDni" class="form-label" style="margin-left: 0px">DNI: </label>
                            <input type="text" id="txtDni" class="form-control" placeholder="12345678" name="txtDni">
                        </div>
                        <input type="submit" name="action" value="Ingresar" class="btn btn-primary btn-block">
                    </form>
                </div>
            </div>
        </div>
    
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
