package com.java.sistemaventas.controladores.venta;

import com.java.sistemaventas.DAO.ClienteDAO;
import com.java.sistemaventas.DAO.EmpleadoDAO;
import com.java.sistemaventas.DAO.VentasDAO;
import com.java.sistemaventas.modelos.Cliente;
import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AddVentaServlet", value = "/venta/add")
public class AddVentaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO((Connection) request.getAttribute("conn"));
        EmpleadoDAO empleadoDAO = new EmpleadoDAO((Connection) request.getAttribute("conn"));

        String action = request.getParameter("action");

        if (!action.equals("view_form")){
            ServletUtil.sendError(response);
            return;
        }

        sendListsToView(request, clienteDAO, empleadoDAO);
        ServletUtil.goToJsp(request, response, "add_venta");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VentasDAO ventasDAO = new VentasDAO((Connection) request.getAttribute("conn"));

        String action = request.getParameter("action");

        if (!action.equals("add")){
            ServletUtil.sendError(response);
            return;
        }

        //addVenta();
        ServletUtil.goToController(request, response, "venta/add?action=view_form");
    }

    private void sendListsToView(HttpServletRequest request, ClienteDAO clienteDAO, EmpleadoDAO empleadoDAO){
        List<Cliente> clientes = clienteDAO.findAll();
        List<Empleado> empleados = empleadoDAO.findAll();

        request.setAttribute("clientes", clientes);
        request.setAttribute("empleados", empleados);
    }
}
