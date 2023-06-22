/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.java.sistemaventas.controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author MarckTK
 */
@WebServlet(name = "Controlador", urlPatterns = {"/controlador"})
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
