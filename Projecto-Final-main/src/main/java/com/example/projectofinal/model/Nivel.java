package com.example.projectofinal.model;

public enum Nivel {
    INICIAL, BASICO, INTERMEDIO, AVANZADO;

    public Nivel siguiente() {
        switch (this) {
            case INICIAL: return BASICO;
            case BASICO: return INTERMEDIO;
            case INTERMEDIO: return AVANZADO;
            default: return null;
        }
    }
}
