package com.java.sistemaventas.DAO;

import com.java.sistemaventas.modelos.Cliente;
import com.java.sistemaventas.util.ExcepcionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cliente");

            while (rs.next()) {
                Cliente cliente = getCliente(rs);
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return clientes;
    }

    public static Cliente getCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();

        c.setIdCliente(rs.getInt("IdCliente"));
        c.setDni(rs.getString("Dni"));
        c.setNombres(rs.getString("Nombres"));
        c.setDireccion(rs.getString("Direccion"));
        c.setEstado(rs.getString("Estado"));

        return c;
    }
}
