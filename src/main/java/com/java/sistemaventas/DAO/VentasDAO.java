package com.java.sistemaventas.DAO;

import com.java.sistemaventas.modelos.Cliente;
import com.java.sistemaventas.modelos.Empleado;
import com.java.sistemaventas.modelos.Producto;
import com.java.sistemaventas.modelos.Ventas;
import com.java.sistemaventas.util.ExcepcionSQL;

import java.sql.*;
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

    public void add(Ventas ventas) {
        String sql;

        if (ventas.getIdVentas()!=0 && ventas.getIdVentas() > 0) {
            sql = "update ventas set IdCliente = ?, IdEmpleado = ?, NumeroSerie = ?, FechaVentas, Monto, Estado = ?  where IdVentas = ?";
        } else {
            sql = "insert into ventas (IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) values (?,?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ventas.getCliente().getIdCliente());
            stmt.setInt(2, ventas.getEmpleado().getIdEmpleado());
            stmt.setString(3, ventas.getNumeroSerie());
            stmt.setTimestamp(4, Timestamp.valueOf(ventas.getFechaVentas()));
            stmt.setDouble(5, ventas.getMonto());
            stmt.setString(6, ventas.getEstado());

            if (ventas.getIdVentas() != 0 && ventas.getIdVentas() > 0) {
                stmt.setInt(7, ventas.getIdVentas());
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }
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
