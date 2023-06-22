<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Productos | Sistema de Ventas</title>
    <%@include file="/WEB-INF/imports/header_imports.jsp" %>
</head>

<body>
<%@include file="/WEB-INF/commons/header.jsp" %>

<div class="container-fluid p-5 mt-3">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
                <h3 class="card-title pb-3">Lista de Productos</h3>
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
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Stock</th>
                        <th scope="col">Estado</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.productos}" var="p">
                        <tr>
                            <th scope="row">${p.idProducto}</th>
                            <td>${p.nombres}</td>
                            <td>S/. ${p.precio}</td>
                            <td>${p.stock}</td>
                            <td>${p.estado == 1 ? "Nuevo" : "2da Mano"}</td>
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

