package com.example.projectofinal.model;

public class ReglaNegocio {

    private int capacidadGrupos;
    private boolean conflictoHorario;
    private boolean prerequisitosNivel;
    private int clasesIndividuales;
    private boolean cierreCiclo;

    public ReglaNegocio(int capacidadGrupos, boolean conflictoHorario, boolean prerequisitosNivel,
                        int clasesIndividuales, boolean cierreCiclo) {
        this.capacidadGrupos = capacidadGrupos;
        this.conflictoHorario = conflictoHorario;
        this.prerequisitosNivel = prerequisitosNivel;
        this.clasesIndividuales = clasesIndividuales;
        this.cierreCiclo = cierreCiclo;
    }

    public int getCapacidadGrupos() { return capacidadGrupos; }
    public boolean isConflictoHorario() { return conflictoHorario; }
    public boolean isPrerequisitosNivel() { return prerequisitosNivel; }
    public int getClasesIndividuales() { return clasesIndividuales; }
    public boolean isCierreCiclo() { return cierreCiclo; }
}
