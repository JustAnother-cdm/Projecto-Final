package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador extends Persona {
    public ArrayList<Profesor> listaProfesor;
    public ArrayList<Estudiante> listaEstudiante;

    public Administrador(String nombre, String cedula, LocalDate fechaNacimiento) {
        super(nombre, cedula, fechaNacimiento);
        listaProfesor = new ArrayList<>();
        listaEstudiante = new ArrayList<>();
    }

    public ArrayList<Profesor> getListaProfesor() {
        return listaProfesor;
    }

    public void setListaProfesor(ArrayList<Profesor> listaProfesor) {
        this.listaProfesor = listaProfesor;
    }

    public ArrayList<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(ArrayList<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public boolean modificarEstudiante(String nombre, String cedula, LocalDate fechaNacimiento, String matricula, String[][] horario, ArrayList<Boolean> Asistencia, String progreso){
        for (Estudiante estudiante : listaEstudiante) {
            if (estudiante.getCedula().equals(cedula)) {
                estudiante.actualizarDatos(nombre, cedula, fechaNacimiento, matricula, horario, Asistencia, progreso);
                return true;
            }
        }
        return false;
    }

    public boolean modificarProfesor(String nombre, String cedula, LocalDate fechaNacimiento, String[][] horarios, ArrayList<Estudiante> listEstudiante){
        for (Profesor profesor : listaProfesor) {
            if (profesor.getCedula().equals(cedula)) {
                if(nombre != null)profesor.setNombre(nombre);
                if(fechaNacimiento != null)profesor.setFechaNacimiento(fechaNacimiento);
                profesor.setCedula(cedula);
                if(horarios != null)profesor.setHorarios(horarios);
                if(listEstudiante != null)profesor.setListEstudiante(listEstudiante);

                return true;
            }
        }
        return false;
    }
}
