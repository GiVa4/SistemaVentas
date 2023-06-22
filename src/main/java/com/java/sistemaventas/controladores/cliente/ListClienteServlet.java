package com.java.sistemaventas.controladores.cliente;

import com.java.sistemaventas.DAO.ClienteDAO;
import com.java.sistemaventas.DAO.EmpleadoDAO;
import com.java.sistemaventas.modelos.Cliente;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ListClienteServlet", value = "/cliente/list")
public class ListClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO((Connection) request.getAttribute("conn"));
        List<Cliente> clientes = clienteDAO.findAll();

        request.setAttribute("clientes", clientes);

        ServletUtil.goToJsp(request, response, "listas/Clientes");
    }
}
