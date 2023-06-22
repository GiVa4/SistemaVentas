/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.sistemaventas.modelos;

/**
 *
 * @author MarckTK
 */
public class Empleado {
    int IdEmpleado;
    String Dni;
    String Nombres;
    String Telefono;
    String Estado;
    String User;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String dni, String nombres, String telefono, String estado, String user) {
        IdEmpleado = idEmpleado;
        Dni = dni;
        Nombres = nombres;
        Telefono = telefono;
        Estado = estado;
        User = user;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }
}
