package com.java.sistemaventas.modelos;

public class Producto {
    private int IdProducto;
    private String Nombres;
    private double Precio;
    private int Stock;
    private String Estado;

    public Producto() {
    }

    public Producto(int idProducto, String nombres, double precio, int stock, String estado) {
        IdProducto = idProducto;
        Nombres = nombres;
        Precio = precio;
        Stock = stock;
        Estado = estado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int idProducto) {
        IdProducto = idProducto;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
