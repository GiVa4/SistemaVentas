package com.java.sistemaventas.controladores.venta;

import com.java.sistemaventas.DAO.ClienteDAO;
import com.java.sistemaventas.DAO.EmpleadoDAO;
import com.java.sistemaventas.DAO.VentasDAO;
import com.java.sistemaventas.modelos.Cliente;
import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.modelos.Ventas;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AddVentaServlet", value = "/venta/add")
public class AddVentaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO((Connection) request.getAttribute("conn"));
        EmpleadoDAO empleadoDAO = new EmpleadoDAO((Connection) request.getAttribute("conn"));

        String action = request.getParameter("action");

        if (!action.equals("view_form")) {
            ServletUtil.sendError(response);
            return;
        }

        String showMessageStr = request.getParameter("showMsg");

        if (!showMessageStr.equals("true")) {
            goToAddForm(request, response, clienteDAO, empleadoDAO, false);
            return;
        }

        goToAddForm(request, response, clienteDAO, empleadoDAO, true);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VentasDAO ventasDAO = new VentasDAO((Connection) request.getAttribute("conn"));

        String action = request.getParameter("action");

        if (!action.equals("add")) {
            ServletUtil.sendError(response);
            return;
        }

        addVenta(ventasDAO, request);
        ServletUtil.goToController(request, response, "venta/add?action=view_form");
    }

    private void addVenta(VentasDAO ventasDAO, HttpServletRequest req) {
        Ventas ventas = new Ventas(
                ServletUtil.getId(req),
                new Cliente(Integer.parseInt(req.getParameter("idCliente"))),
                new Empleado(Integer.parseInt(req.getParameter("idEmpleado"))),
                req.getParameter("numero_serie"),
                LocalDateTime.now(), //fecha venta
                Double.parseDouble(req.getParameter("monto")),
                req.getParameter("estado")
        );

        ventasDAO.add(ventas);
    }

    private void goToAddForm(HttpServletRequest req, HttpServletResponse resp, ClienteDAO clienteDAO, EmpleadoDAO empleadoDAO, boolean showMessage) throws ServletException, IOException {
        if (showMessage) {
            req.setAttribute("msg", "Producto agregado con Exito");
        }

        sendListsToView(req, clienteDAO, empleadoDAO);
        ServletUtil.goToJsp(req, resp, "add_venta");
    }

    private void sendListsToView(HttpServletRequest request, ClienteDAO clienteDAO, EmpleadoDAO empleadoDAO) {
        List<Cliente> clientes = clienteDAO.findAll();
        List<Empleado> empleados = empleadoDAO.findAll();

        request.setAttribute("clientes", clientes);
        request.setAttribute("empleados", empleados);
    }
}
