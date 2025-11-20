package com.example.projectofinal.model;

import java.time.LocalDate;

public class Asistencia {

    private final Estudiante estudiante;
    private final CursoInstrumento curso;
    private final LocalDate fecha;
    private boolean presente;

    public Asistencia(Estudiante estudiante, CursoInstrumento curso, LocalDate fecha, boolean presente) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fecha = fecha;
        this.presente = presente;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public CursoInstrumento getCurso() { return curso; }
    public LocalDate getFecha() { return fecha; }
    public boolean isPresente() { return presente; }
    public void setPresente(boolean presente) { this.presente = presente; }
}
