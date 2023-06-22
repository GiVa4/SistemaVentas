package com.java.sistemaventas.DAO;

import com.java.sistemaventas.modelos.Detalle_Ventas;
import com.java.sistemaventas.modelos.Producto;
import com.java.sistemaventas.modelos.Ventas;
import com.java.sistemaventas.util.ExcepcionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Detalle_VentasDAO {
    private Connection conn;

    public Detalle_VentasDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Detalle_Ventas> findAll() {
        List<Detalle_Ventas> dvs = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from detalle_ventas");

            while (rs.next()) {
                Detalle_Ventas dv = getDetalle_Ventas(rs);
                dvs.add(dv);
            }

        } catch (SQLException e) {
            throw new ExcepcionSQL(e.getMessage(), e.getCause());
        }

        return dvs;
    }

    public static Detalle_Ventas getDetalle_Ventas(ResultSet rs) throws SQLException {
        Detalle_Ventas dv = new Detalle_Ventas();

        dv.setIdDetalleVentas(rs.getInt("IdDetalleVentas"));
        dv.setCantidad(rs.getInt("Cantidad"));
        dv.setPrecioVenta(rs.getDouble("PrecioVenta"));

        Ventas v = new Ventas();
        v.setIdVentas(rs.getInt("IdVentas"));
        dv.setVentas(v);

        Producto p = new Producto();
        p.setIdProducto(rs.getInt("IdProducto"));
        p.setNombres(rs.getString("Nombres"));
        p.setPrecio(rs.getDouble("Precio"));
        p.setStock(rs.getInt("Stock"));
        p.setEstado(rs.getString("Estado"));

        dv.setProducto(p);

        return dv;
    }
}
