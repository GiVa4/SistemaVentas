/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.sistemaventas.DAO;

import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.util.ExcepcionSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private Connection conn;

    public EmpleadoDAO(Connection conn) {
        this.conn = conn;
    }

    public Empleado login(String User, String Dni) {
        Empleado empleado = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("select * from empleado where User = ? and Dni = ?");
            stmt.setString(1, User);
            stmt.setString(2, Dni);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                empleado = getEmpleado(rs);
            }
        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return empleado;
    }

    public List<Empleado> findAll() {
        List<Empleado> empleados = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from empleado");

            while (rs.next()) {
                Empleado empleado = getEmpleado(rs);
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return empleados;
    }

    public static Empleado getEmpleado(ResultSet rs) throws SQLException {
        Empleado e = new Empleado();

        e.setIdEmpleado(rs.getInt("IdEmpleado"));
        e.setDni(rs.getString("Dni"));
        e.setNombres(rs.getString("Nombres"));
        e.setTelefono(rs.getString("Telefono"));
        e.setEstado(rs.getString("Estado"));
        e.setUser(rs.getString("User"));

        return e;
    }
}
