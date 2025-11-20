package com.example.projectofinal.model;

import java.time.LocalDate;

public class Administrador extends Persona {

    public Administrador(String nombre, String cedula, LocalDate fechaNacimiento) {
        super(nombre, cedula, fechaNacimiento);
    }

    public String reportarProgreso() {
        return "Reporte generado.";
    }

    public String reportarAsistencia() {
        return "Asistencia registrada.";
    }

    public String recomendarPracticas() {
        return "Prácticas recomendadas.";
    }
}
