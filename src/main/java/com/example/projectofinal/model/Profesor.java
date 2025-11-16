package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Persona {
    public String[][] horarios = new String[7][4];
    public ArrayList<Boolean> Asistencia = new ArrayList<>();

    public Profesor(String nombre, String cedula, LocalDate fechaNacimiento, String[][] horarios, ArrayList<Boolean> asistencia) {
        super(nombre, cedula, fechaNacimiento);
        this.horarios = horarios;
        Asistencia = asistencia;
    }

    public String[][] getHorarios() {
        return horarios;
    }

    public void setHorarios(String[][] horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Boolean> getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(ArrayList<Boolean> asistencia) {
        Asistencia = asistencia;
    }
}
