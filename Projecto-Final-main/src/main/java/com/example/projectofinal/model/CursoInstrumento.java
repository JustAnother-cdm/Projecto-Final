package com.example.projectofinal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CursoInstrumento {

    private CursoTipo tipo;
    private Nivel nivel;
    private String horario; // e.g. "Lunes 15:00-16:00"
    private int capacidad;
    private String aula;
    private Profesor profesor;

    private final List<Estudiante> inscritos = new ArrayList<>();
    private boolean cicloCerrado = false; // para 'cierre de ciclo' (evaluación registrada)

    public CursoInstrumento(CursoTipo tipo, Nivel nivel, String horario, int capacidad, String aula, Profesor profesor) {
        this.tipo = tipo;
        this.nivel = nivel;
        this.horario = horario;
        this.capacidad = capacidad;
        this.aula = aula;
        this.profesor = profesor;
    }

    public CursoTipo getTipo() { return tipo; }
    public void setTipo(CursoTipo tipo) { this.tipo = tipo; }

    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) { this.nivel = nivel; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    public List<Estudiante> getInscritos() { return inscritos; }

    public boolean isCicloCerrado() { return cicloCerrado; }
    public void marcarCicloCerrado() { this.cicloCerrado = true; }

    public boolean tieneCupo() {
        return inscritos.size() < capacidad;
    }

    public boolean inscribir(Estudiante e) {
        if (!tieneCupo()) return false;
        if (inscritos.contains(e)) return false;
        inscritos.add(e);
        return true;
    }

    public boolean removerInscrito(Estudiante e) {
        return inscritos.remove(e);
    }

    @Override
    public String toString() {
        return tipo + " " + nivel + " - " + horario + " (" + inscritos.size() + "/" + capacidad + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoInstrumento)) return false;
        CursoInstrumento that = (CursoInstrumento) o;
        return Objects.equals(tipo, that.tipo) &&
               Objects.equals(nivel, that.nivel) &&
               Objects.equals(horario, that.horario) &&
               Objects.equals(aula, that.aula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, nivel, horario, aula);
    }
}
