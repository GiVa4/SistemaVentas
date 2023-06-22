package com.java.sistemaventas.modelos;

import java.time.LocalDateTime;

public class Ventas {
    private int IdVentas;
    private Cliente cliente;
    private Empleado empleado;
    private String NumeroSerie;
    private LocalDateTime FechaVentas;
    private double Monto;
    private String Estado;

    public Ventas() {
    }

    public Ventas(int idVentas, Cliente cliente, Empleado empleado, String numeroSerie, LocalDateTime fechaVentas, double monto, String estado) {
        IdVentas = idVentas;
        this.cliente = cliente;
        this.empleado = empleado;
        NumeroSerie = numeroSerie;
        FechaVentas = fechaVentas;
        Monto = monto;
        Estado = estado;
    }

    public int getIdVentas() {
        return IdVentas;
    }

    public void setIdVentas(int idVentas) {
        IdVentas = idVentas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        NumeroSerie = numeroSerie;
    }

    public LocalDateTime getFechaVentas() {
        return FechaVentas;
    }

    public void setFechaVentas(LocalDateTime fechaVentas) {
        FechaVentas = fechaVentas;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
