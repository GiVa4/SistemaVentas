package com.java.sistemaventas.DAO;

import com.java.sistemaventas.modelos.Producto;
import com.java.sistemaventas.util.ExcepcionSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private Connection conn;

    public ProductoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from producto");

            while (rs.next()) {
                Producto producto = getProducto(rs);
                productos.add(producto);
            }

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return productos;
    }

    public Producto findById(int id) {
        Producto producto = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("select * from producto where IdProducto = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = getProducto(rs);
            }

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return producto;
    }

    public void add(Producto producto) {
        String sql;

        if (producto.getIdProducto()!=0 && producto.getIdProducto() > 0) {
            sql = "update producto set Nombres = ?, Precio = ?, Stock = ?, Estado = ?  where IdProducto = ?";
        } else {
            sql = "insert into producto (Nombres, Precio, Stock, Estado) values (?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombres());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            stmt.setString(4, producto.getEstado());

            if (producto.getIdProducto() != 0 && producto.getIdProducto() > 0) {
                stmt.setInt(5, producto.getIdProducto());
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }
    }

    private Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();

        p.setIdProducto(rs.getInt("IdProducto"));
        p.setNombres(rs.getString("Nombres"));
        p.setPrecio(rs.getDouble("Precio"));
        p.setStock(rs.getInt("Stock"));
        p.setEstado(rs.getString("Estado"));

        return p;
    }
}
