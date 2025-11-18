package com.example.projectofinal.Controller;

import com.example.projectofinal.model.Administrador;
import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Estudiante;
import com.example.projectofinal.model.Profesor;

import java.util.List;

public class AdministradorController {

    // Crear curso nuevo
    public CursoInstrumento crearCurso(String instrumento, int nivel, String aula) {
        return new CursoInstrumento(instrumento, nivel, aula);
    }

    // Modificar estudiante
    public boolean modificarEstudiante(List<Estudiante> lista, Estudiante nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(nuevo.getCedula())) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    // Modificar profesor
    public boolean modificarProfesor(List<Profesor> lista, Profesor nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(nuevo.getCedula())) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    // Reporte de asistencia del curso
    public String generarReporteAsistencia(CursoInstrumento curso) {
        return curso.generarReporteAsistencia();
    }

    // Reporte ocupación de aulas
    public String reporteOcupacionAulas(List<CursoInstrumento> cursos) {
        StringBuilder sb = new StringBuilder();
        for (CursoInstrumento c : cursos) {
            sb.append("Aula: ").append(c.getAula())
                    .append(" | Horario: ").append(c.getHorario()).append("\n");
        }
        return sb.toString();
    }
}