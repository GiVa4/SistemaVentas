package com.java.sistemaventas.controladores.ventas;

import com.java.sistemaventas.DAO.VentasDAO;
import com.java.sistemaventas.modelos.Ventas;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AddVentasServlet", urlPatterns = {"/ventas/add"})
public class AddVentasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VentasDAO ventasDAO = new VentasDAO((Connection) req.getAttribute("conn"));
        String nuevo = req.getParameter("new");

        if (nuevo == null) {
            ServletUtil.sendError(resp);
            return;
        }

        switch (nuevo) {
            case "true":
                goToAddForm(req, resp, false);
                break;
            default:
                ServletUtil.sendError(resp);
        }
    }

    private void goToAddForm(HttpServletRequest req, HttpServletResponse resp, boolean showMessage) throws ServletException, IOException {
        if (showMessage) {
            req.setAttribute("msg", "Producto agregado con Exito");
        }
        req.getRequestDispatcher("/WEB-INF/listas/Ventas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VentasDAO ventasDAO = new VentasDAO((Connection) req.getAttribute("conn"));
        //add(ventasDAO, req);
        goToAddForm(req, resp, true);
    }

    /*private void add(VentasDAO ventasDAO, HttpServletRequest req) {
        Ventas ventas = new Ventas( ServletUtil.getId(req),
                req.getParameter("codigo"),
                req.getParameter("nombre"),
                Existencia.valueOf(req.getParameter("existencia")),
                Double.parseDouble(req.getParameter("precio"))
        );

        ventasDAO.add(ventas);
    }*/
}