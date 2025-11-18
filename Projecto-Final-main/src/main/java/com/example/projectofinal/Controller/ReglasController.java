package com.example.projectofinal.Controller;

import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Estudiante;

public class ReglaNegocioController {

    // Regla: Cupo
    public boolean validarCupo(CursoInstrumento curso) {
        return curso.getCantidadEstudiantes() < curso.getRegla().getCapacidadGrupos();
    }

    // Regla: Prerrequisito de nivel
    public boolean validarPrerequisito(Estudiante estudiante, CursoInstrumento curso) {
        int nivelEst = estudiante.getNivelActual();
        int nivelCurso = curso.getNivelCurso();
        return nivelEst >= nivelCurso - 1;
    }

    // Regla: Conflicto de horario
    public boolean conflictoHorario(CursoInstrumento a, CursoInstrumento b) {
        return a.getHorario().equals(b.getHorario()) &&
                (a.getAula().equals(b.getAula()) ||
                        a.getProfesor().equals(b.getProfesor()));
    }
}
