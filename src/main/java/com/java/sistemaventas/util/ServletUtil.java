package com.java.sistemaventas.util;

import com.java.sistemaventas.modelos.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ServletUtil {
    public static void sendError(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Lo sentimos, el recurso solicitado no está disponible :(");
    }

    public static int getId(HttpServletRequest request) {
        String idEmpleadoStr;
        try {
            idEmpleadoStr = request.getParameter("IdEmpleado");
        } catch (NullPointerException e) {
            idEmpleadoStr = "";
        }
        Integer IdEmpleado;
        try {
            IdEmpleado = Integer.parseInt(idEmpleadoStr);
        } catch (NumberFormatException e) {
            IdEmpleado = 0;
        }
        return IdEmpleado;
    }

    public static Empleado getSessionEmpleado(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Empleado) session.getAttribute("empleado");
    }

    public static void goToJsp(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException {

        try {
            request.getServletContext().getRequestDispatcher("/WEB-INF/" + fileName + ".jsp").forward(request, response);
        } catch (NullPointerException e) {
            sendError(response);
        }
    }

    public static void goToController(HttpServletRequest request, HttpServletResponse response, String controller) throws IOException {

        try {
            response.sendRedirect(request.getContextPath() + "/" + controller);
        } catch (NullPointerException e) {
            sendError(response);
        }
    }
}
