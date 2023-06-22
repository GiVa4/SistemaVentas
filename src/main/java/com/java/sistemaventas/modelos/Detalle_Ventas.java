package com.java.sistemaventas.modelos;

public class Detalle_Ventas {
    private int IdDetalleVentas;
    private Ventas ventas;
    private Producto producto;
    private int Cantidad;
    private double PrecioVenta;

    public Detalle_Ventas() {
    }

    public Detalle_Ventas(int idDetalleVentas, Ventas ventas, Producto producto, int cantidad, double precioVenta) {
        IdDetalleVentas = idDetalleVentas;
        this.ventas = ventas;
        this.producto = producto;
        Cantidad = cantidad;
        PrecioVenta = precioVenta;
    }

    public int getIdDetalleVentas() {
        return IdDetalleVentas;
    }

    public void setIdDetalleVentas(int idDetalleVentas) {
        IdDetalleVentas = idDetalleVentas;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        PrecioVenta = precioVenta;
    }
}
