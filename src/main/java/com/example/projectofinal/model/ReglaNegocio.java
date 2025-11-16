package com.example.projectofinal.model;

import java.time.LocalDate;

public class ReglaNegocio {
    public int capacidadGrupos;
    public boolean conflictosHorarios;
    public LocalDate cierreCiclo;
    public boolean preRequisitos;

    public ReglaNegocio(boolean preRequisitos, LocalDate cierreCiclo, int capacidadGrupos) {
        this.preRequisitos = preRequisitos;
        this.cierreCiclo = cierreCiclo;
        this.capacidadGrupos = capacidadGrupos;
    }

    public int getCapacidadGrupos() {
        return capacidadGrupos;
    }

    public boolean isConflictosHorarios() {
        return conflictosHorarios;
    }

    public LocalDate getCierreCiclo() {
        return cierreCiclo;
    }

    public boolean isPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(boolean preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public void setConflictosHorarios(boolean conflictosHorarios) {
        this.conflictosHorarios = conflictosHorarios;
    }

    public void setCapacidadGrupos(int capacidadGrupos) {
        this.capacidadGrupos = capacidadGrupos;
    }
}
