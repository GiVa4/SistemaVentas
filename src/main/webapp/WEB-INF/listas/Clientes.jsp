<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Clientes | Sistema de Ventas</title>
    <%@include file="/WEB-INF/imports/header_imports.jsp" %>
</head>

<body>
<%@include file="/WEB-INF/commons/header.jsp" %>

<div class="container-fluid p-5 mt-3">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
                <h3 class="card-title pb-3">Lista de Clientes</h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-nowrap align-middle">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">DNI</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Direcci&oacute;n</th>
                        <th scope="col">Estado</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.clientes}" var="c">
                        <tr>
                            <th scope="row">${c.idCliente}</th>
                            <td>${c.dni}</td>
                            <td>${c.nombres}</td>
                            <td>${c.direccion}</td>
                            <td>${c.estado == 1 ? "Activo" : "Inactivo"}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/imports/footer_imports.jsp" %>
</body>
</html>
