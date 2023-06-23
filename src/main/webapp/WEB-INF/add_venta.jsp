<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Ventas | Sistema de Ventas</title>
    <%@include file="/WEB-INF/imports/header_imports.jsp" %>
</head>

<body>
<%@include file="/WEB-INF/commons/header.jsp" %>


<div class="container-fluid p-5 mt-3">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
                <h3 class="card-title pb-3">Registrar Venta</h3>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-lg-12">
            <form class="form-sign" action="${pageContext.request.contextPath}/ventas/add?action=add" method="post">

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

<%@include file="/WEB-INF/imports/footer_imports.jsp" %>
</body>
</html>