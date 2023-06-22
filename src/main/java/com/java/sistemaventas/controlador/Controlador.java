package com.java.sistemaventas.controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action= request.getParameter("action");
        switch (action) {
            case "Principal":
                getServletContext().getRequestDispatcher("/WEB-INF/Principal.jsp").forward(request, response);
                break;
            case "Producto":
                getServletContext().getRequestDispatcher("/WEB-INF/listas/Productos.jsp").forward(request, response);
                break;
            case "Cliente":
                getServletContext().getRequestDispatcher("/WEB-INF/listas/Clientes.jsp").forward(request, response);
                break;
            case "Empleado":
                getServletContext().getRequestDispatcher("/WEB-INF/listas/Empleado.jsp").forward(request, response);
                break;
            case "NuevaVenta":
                getServletContext().getRequestDispatcher("/WEB-INF/RegistrarVenta.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


}
