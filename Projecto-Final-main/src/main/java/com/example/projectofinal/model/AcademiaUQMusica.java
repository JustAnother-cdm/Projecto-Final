package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class AcademiaUQMusica {
    public String nit;
    public  ArrayList<Estudiante> listaEstudiante;
    public ArrayList<Profesor>  listaProfesor;
    public ArrayList<Administrador>  listaAdministrador;
    public ReglaNegocio reglasNegocio;
    public ArrayList<CursoInstrumento> listaCursoInstrumento;

    public AcademiaUQMusica(String nit, ReglaNegocio reglasNegocio) {
        this.nit = nit;
        this.reglasNegocio = reglasNegocio;
        listaEstudiante = new ArrayList<>();
        listaProfesor = new ArrayList<>();
        listaAdministrador = new ArrayList<>();
        listaCursoInstrumento = new ArrayList<>();

    }


    //Crear
    public void crearEstudiante(Estudiante e){
        listaEstudiante.add(e);
    }
    public void crearProfesor(Profesor p){
        listaProfesor.add(p);
    }
    public void crearAdministrador(Administrador a){
        listaAdministrador.add(a);
    }
    public void crearCursoInstrumento(CursoInstrumento c){
        listaCursoInstrumento.add(c);
    }


}