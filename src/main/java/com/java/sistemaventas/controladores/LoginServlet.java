package com.java.sistemaventas.controladores;

import java.io.IOException;

import com.java.sistemaventas.DAO.EmpleadoDAO;
import com.java.sistemaventas.modelos.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //Se recuperan los valores del formulario
            String User = request.getParameter("txtUser");
            String Dni = request.getParameter("txtDni");

            //Se crean los modelos
            Empleado empleado;
            EmpleadoDAO empleadoDAO = new EmpleadoDAO((Connection) request.getAttribute("conn"));//Se pide la conexion a la base de datos

            //Se busca el usuario en la base de datos
            empleado = empleadoDAO.login(User, Dni);

            //Si el usuario existe
            if (empleado != null) {
                //Se inicia la sesion
                HttpSession session = request.getSession();
                //Se guardan los datos del usuario en la sesion
                session.setAttribute("empleado", empleado);
                response.sendRedirect(request.getContextPath()+"/home");
            } else {
                //Se envia el error de datos incorrectos
                request.setAttribute("msg", "'\u00a1Los datos ingresados son incorrectos!'");
                //Se redirecciona al login
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
    }

}