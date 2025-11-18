package com.example.projectofinal.Controller;

import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Estudiante;
import com.example.projectofinal.model.ReglaNegocio;

public class EstudianteController {

    // Registrar estudiante en un curso
    public boolean inscribirEstudianteEnCurso(Estudiante estudiante, CursoInstrumento curso, ReglaNegocio reglas) {

        // Regla 1: Validar cupo
        if (curso.getCantidadEstudiantes() >= reglas.getCapacidadGrupos()) {
            return false;
        }

        // Regla 2: Validar prerrequisito
        if (curso.getNivelCurso() > 1) {
            if (estudiante.getNivelActual() != curso.getNivelCurso() - 1) {
                return false;
            }
        }

        // Inscribir
        curso.getListaEstudiantes().add(estudiante);
        estudiante.getListaCursos().add(curso);

        return true;
    }

    // Consultar horario de un estudiante
    public String consultarHorario(Estudiante estudiante) {
        return estudiante.getHorario();
    }

    // Obtener progreso del estudiante en un curso
    public double consultarProgreso(Estudiante estudiante, CursoInstrumento curso) {
        return curso.obtenerValoracionEstudiante(estudiante.getCedula());
    }
}