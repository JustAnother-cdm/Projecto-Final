package com.example.projectofinal.model;

import java.time.LocalDate;

abstract class Persona {
    protected String nombre;
    protected String cedula;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String cedula, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
