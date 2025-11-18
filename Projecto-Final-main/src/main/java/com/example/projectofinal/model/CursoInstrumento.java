package com.example.projectofinal.model;

import java.util.ArrayList;

public class CursoInstrumento {
    public String piano;
    public String violin;
    public String guitarra;
    public String canto;

    public ArrayList<Estudiante> listaEstudiante;

    public CursoInstrumento(String piano, String violin, String guitarra, String canto) {
        this.piano = piano;
        this.violin = violin;
        this.guitarra = guitarra;
        this.canto = canto;
        this.listaEstudiante = new ArrayList<>();
    }

    public String getPiano() {
        return piano;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public String getViolin() {
        return violin;
    }

    public void setViolin(String violin) {
        this.violin = violin;
    }

    public String getGuitarra() {
        return guitarra;
    }

    public void setGuitarra(String guitarra) {
        this.guitarra = guitarra;
    }

    public String getCanto() {
        return canto;
    }

    public void setCanto(String canto) {
        this.canto = canto;
    }
}
