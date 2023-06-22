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

        if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
            sql = "update almacen set codigo = ?, existencia = ?, nombre = ?, precio = ?  where id = ?";
        } else {
            sql = "insert into almacen (codigo, existencia, nombre, precio) values (?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getCodigo());
            stmt.setString(2, producto.getExistencia().toString());
            stmt.setString(3, producto.getNombre());
            stmt.setDouble(4, producto.getPrecio());

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setInt(5, producto.getId());
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }
    }

    private Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();

        p.setId(rs.getInt("id"));
        p.setCodigo(rs.getString("codigo"));
        p.setExistencia(Existencia.valueOf(rs.getString("existencia")));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getDouble("precio"));

        return p;
    }
}
