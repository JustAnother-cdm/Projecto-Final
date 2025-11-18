package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudiante extends Persona {

    private String matricula;
    public String [][] horario = new String [7][4];
    public ArrayList<Boolean> asistencia;
    public String progreso;
    public Profesor theProfesor;



    public Estudiante(String nombre, String cedula, LocalDate fechaNacimiento, String matricula, String[][] horario, ArrayList<Boolean> asistencia, String progreso, Profesor theProfesor) {
        super(nombre, cedula, fechaNacimiento);
        this.asistencia = asistencia;
        this.horario = horario;
        this.matricula = matricula;
        this.progreso = progreso;
        this.theProfesor = theProfesor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String[][] getHorario() {
        return horario;
    }

    public void setHorario(String[][] horario) {
        this.horario = horario;
    }

    public ArrayList<Boolean> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(ArrayList<Boolean> asistencia) {
        this.asistencia =asistencia;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public void actualizarDatos(String nombre, String cedula, LocalDate fechaNacimiento, String matricula, String[][] horario, ArrayList<Boolean> asistencia, String progreso) {
        if(nombre!= null) setNombre(nombre);
        if(cedula!= null)setCedula(cedula);
        if(fechaNacimiento!= null)setFechaNacimiento(fechaNacimiento);
        if(asistencia!= null)setAsistencia(asistencia);
        if(matricula!= null)setMatricula(matricula);
        if(horario!= null)setHorario(horario);
        if(progreso!= null)setProgreso(progreso);
    }

    public String [][] consultarHorario() {
        return getHorario();
    }


}
