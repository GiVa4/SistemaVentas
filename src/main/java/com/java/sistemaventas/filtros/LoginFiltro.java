package com.java.sistemaventas.filtros;

import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.util.ServletUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter({"/home"})
public class LoginFiltro implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Empleado empleado = ServletUtil.getSessionEmpleado((HttpServletRequest) request);

        try {
            if (empleado != null){
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, ¡necesitas iniciar sesión para ver esta página!");
            }
        } catch (NullPointerException e) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, ¡necesitas iniciar sesión para ver esta página!");
        }
    }
}
