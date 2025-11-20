package com.example.projectofinal.model;

import java.util.ArrayList;
import java.util.List;

public class AcademiaUCMusica {

    private String nombre;
    private String nit;

    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<CursoInstrumento> cursos = new ArrayList<>();

    public AcademiaUCMusica(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public void agregarEstudiante(Estudiante e) {
        if (!estudiantes.contains(e)) estudiantes.add(e);
    }

    public void agregarProfesor(Profesor p) {
        if (!profesores.contains(p)) profesores.add(p);
    }

    public void agregarCurso(CursoInstrumento c) {
        if (!cursos.contains(c)) cursos.add(c);
    }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public List<Profesor> getProfesores() { return profesores; }
    public List<CursoInstrumento> getCursos() { return cursos; }
}
