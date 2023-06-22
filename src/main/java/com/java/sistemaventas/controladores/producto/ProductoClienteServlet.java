package com.java.sistemaventas.controladores.producto;

import com.java.sistemaventas.DAO.ProductoDAO;
import com.java.sistemaventas.modelos.Producto;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ListProductoServlet", value = "/producto/list")
public class ProductoClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoDAO productoDAO = new ProductoDAO((Connection) request.getAttribute("conn"));
        List<Producto> productos = productoDAO.findAll();

        request.setAttribute("productos", productos);

        ServletUtil.goToJsp(request, response, "listas/Productos");
    }
}
