<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/imports/header_imports.jsp" %>
    <title>Login del Sistema</title>
</head>

<body>

<c:if test="${not empty requestScope.msg}">
    <div class="alert alert-success" role="alert">
        <p>${requestScope.msg}</p>
    </div>
</c:if>

<div class="container mt-4 col-lg-4">
    <div class="card col-sm-10">
        <div class="card-body">
            <form class="form-sign" action="${pageContext.request.contextPath}/login" method="post">

                <div class="form-group text-center">
                    <h3>Iniciar Sesión</h3>
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

<%@include file="/WEB-INF/imports/footer_imports.jsp" %>
</body>
</html>
