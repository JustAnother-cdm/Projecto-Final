package com.example.projectofinal.Controller;

import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Profesor;

public class ProfesorController {

    // Agregar horario disponible al profesor
    public void agregarHorarioDisponible(Profesor profesor, String horario) {
        profesor.getHorarioDisponible().add(horario);
    }

    // Crear clase grupal asignada al profesor
    public boolean crearClaseGrupal(Profesor profesor, CursoInstrumento curso, String horario) {

        // Verificar que el profesor tiene ese horario disponible
        if (!profesor.getHorarioDisponible().contains(horario)) {
            return false;
        }

        // Asignar profesor y horario
        curso.setProfesor(profesor);
        curso.setHorario(horario);

        return true;
    }

    // Registrar asistencia
    public void registrarAsistencia(CursoInstrumento curso, String idEstudiante) {
        curso.agregarAsistencia(idEstudiante);
    }

    // Registrar valoración del progreso
    public void registrarProgreso(CursoInstrumento curso, String idEstudiante, double valoracion) {
        curso.agregarValoracion(idEstudiante, valoracion);
    }
}