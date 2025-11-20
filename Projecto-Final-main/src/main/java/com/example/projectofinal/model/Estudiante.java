package com.example.projectofinal.model;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {

    private final StringProperty matricula;
    private final StringProperty cursoActual;   
    
    private final List<CursoInstrumento> cursosAprobados = new ArrayList<>();

    public Estudiante(String nombre, String cedula, LocalDate fechaNacimiento,
                      String matricula, String cursoActual) {
        super(nombre, cedula, fechaNacimiento);
        this.matricula = new SimpleStringProperty(matricula);
        this.cursoActual = new SimpleStringProperty(cursoActual);
    }


    public String getMatricula() { return matricula.get(); }
    public void setMatricula(String v) { matricula.set(v); }
    public StringProperty matriculaProperty() { return matricula; }

    public String getCursoActual() { return cursoActual.get(); }
    public void setCursoActual(String v) { cursoActual.set(v); }
    public StringProperty cursoActualProperty() { return cursoActual; }


   
    public void aprobarCurso(CursoInstrumento curso) {
        if (!cursosAprobados.contains(curso)) {
            cursosAprobados.add(curso);
        }
    }


    public List<CursoInstrumento> getCursosAprobados() {
        return cursosAprobados;
    }

 
    public boolean haAprobadoNivelPrevio(CursoTipo tipo, Nivel nivelActual) {
        Nivel nivelPrevio = nivelActual.siguiente() == null ? nivelActual : null;

        
        Nivel anterior = null;
        for (Nivel n : Nivel.values()) {
            if (n == nivelActual) break;
            anterior = n;
        }

        if (anterior == null) return true; 

        for (CursoInstrumento c : cursosAprobados) {
            if (c.getTipo() == tipo && c.getNivel() == anterior) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}
