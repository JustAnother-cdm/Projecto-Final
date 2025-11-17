package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Persona {
    public String[][] horarios = new String[7][4];
    public ArrayList<Boolean> Asistencia;
    public ArrayList<Estudiante> listEstudiante;

    public Profesor(String nombre, String cedula, LocalDate fechaNacimiento, String[][] horarios, ArrayList<Estudiante> listEstudiante) {
        super(nombre, cedula, fechaNacimiento);
        this.horarios = horarios;
        Asistencia = new ArrayList<>();
        this.listEstudiante = listEstudiante;
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
