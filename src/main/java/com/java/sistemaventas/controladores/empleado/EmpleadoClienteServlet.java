package com.java.sistemaventas.controladores.empleado;


import com.java.sistemaventas.DAO.EmpleadoDAO;
import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ListEmpleadoServlet", value = "/empleado/list")
public class EmpleadoClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO((Connection) request.getAttribute("conn"));
        List<Empleado> empleados = empleadoDAO.findAll();

        request.setAttribute("empleados", empleados);

        ServletUtil.goToJsp(request, response, "listas/Empleado");
    }
}
