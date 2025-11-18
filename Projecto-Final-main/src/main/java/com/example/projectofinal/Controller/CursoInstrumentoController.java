package com.example.projectofinal.Controller;

import com.example.projectofinal.model.CursoInstrumento;

import java.util.List;

public class CursoInstrumentoController {

    // Validar si un curso tiene cupos disponibles
    public boolean validarCupos(CursoInstrumento curso) {
        return curso.getCantidadEstudiantes() < curso.getRegla().getCapacidadGrupos();
    }

    // Validar conflicto de horario
    public boolean hayConflictoHorario(List<CursoInstrumento> cursos, CursoInstrumento nuevo) {
        for (CursoInstrumento c : cursos) {
            if (c.getHorario().equals(nuevo.getHorario())) {
                if (c.getAula().equals(nuevo.getAula())) return true;
                if (c.getProfesor().equals(nuevo.getProfesor())) return true;
            }
        }
        return false;
    }

    // Registrar evaluación final
    public void registrarEvaluacionFinal(CursoInstrumento curso) {
        curso.setEvaluacionFinal(true);
    }
}