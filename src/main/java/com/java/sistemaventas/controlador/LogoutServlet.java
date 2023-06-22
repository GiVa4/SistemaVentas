package com.java.sistemaventas.controlador;

import com.java.sistemaventas.modelos.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Se obtiene la sesion
        HttpSession session = req.getSession();
        //Se obtienen los datos del empleado
        Empleado empleado = (Empleado) session.getAttribute("empleado");
        if (empleado != null) {
            //Se invalida la sesion
            session.invalidate();
        }
        //Se redirecciona al inicio
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
