package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador extends Persona {
    public ArrayList<Profesor> listaProfesor;

    public Administrador(String nombre, String cedula, LocalDate fechaNacimiento) {
        super(nombre, cedula, fechaNacimiento);
        listaProfesor = new ArrayList<>();
    }

}
