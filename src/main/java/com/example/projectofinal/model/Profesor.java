package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Persona {
    public String[][] horarios = new String[7][4];
    public ArrayList<Boolean> asistencia;
    public ArrayList<Estudiante> listEstudiante;
    public Administrador theAdministrador;

    public Profesor(String nombre, String cedula, LocalDate fechaNacimiento, String[][] horarios, ArrayList<Estudiante> listEstudiante) {
        super(nombre, cedula, fechaNacimiento);
        this.horarios = horarios;
        this.asistencia = new ArrayList<>();
        this.listEstudiante = listEstudiante;
    }

    public String[][] getHorarios() {
        return horarios;
    }

    public void setHorarios(String[][] horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Boolean> getAsistencia() {
        return this.asistencia;
    }

    public void setAsistencia(ArrayList<Boolean> asistencia) {
        this.asistencia = asistencia;
    }

    public ArrayList<Estudiante> getListEstudiante() {
        return listEstudiante;
    }

    public void setListEstudiante(ArrayList<Estudiante> listEstudiante) {
        this.listEstudiante = listEstudiante;
    }
    public ArrayList<Estudiante> RegistrarAsistencia() {
        ArrayList<Estudiante> asistenciaEstudiantes = new ArrayList<>();
        for (Estudiante e : listEstudiante) {
            if (!e.asistencia.isEmpty() && e.asistencia.get(e.asistencia.size() - 1)) {
                asistenciaEstudiantes.add(e);
            }
        }
        return asistenciaEstudiantes;
    }

}
