package com.java.sistemaventas.DAO;

import com.java.sistemaventas.modelos.Cliente;
import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.modelos.Producto;
import com.java.sistemaventas.modelos.Ventas;
import com.java.sistemaventas.util.ExcepcionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {private Connection conn;

    public VentasDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Ventas> findAll() {
        List<Ventas> venta = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ventas");

            while (rs.next()) {
                Ventas ventas = getVentas(rs);
                venta.add(ventas);
            }

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return venta;
    }

    public static Ventas getVentas(ResultSet rs) throws SQLException {
        Ventas v = new Ventas();

        v.setIdVentas(rs.getInt("IdVentas"));
        v.setNumeroSerie(rs.getString("NumeroSerie"));
        v.setFechaVentas(rs.getTimestamp("FechaVentas").toLocalDateTime());
        v.setMonto(rs.getDouble("Monto"));
        v.setEstado(rs.getString("Estado"));

        Empleado e = new Empleado();
        e.setIdEmpleado(rs.getInt("IdEmpleado"));
        e.setDni(rs.getString("Dni"));
        e.setNombres(rs.getString("Nombres"));
        e.setTelefono(rs.getString("Telefono"));
        e.setEstado(rs.getString("Estado"));
        e.setUser(rs.getString("User"));

        v.setEmpleado(e);

        Cliente c = new Cliente();
        c.setIdCliente(rs.getInt("IdCliente"));
        c.setDni(rs.getString("Dni"));
        c.setNombres(rs.getString("Nombres"));
        c.setDireccion(rs.getString("Direccion"));
        c.setEstado(rs.getString("Estado"));

        v.setCliente(c);

        return v;
    }
}
