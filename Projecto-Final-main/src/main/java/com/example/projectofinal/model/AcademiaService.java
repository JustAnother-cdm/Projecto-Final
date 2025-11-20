package com.example.projectofinal.model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AcademiaService implements IAsistible, IReportable, ICursoGestionable {

    private final AcademiaUCMusica academia;
    private final ReglaNegocio reglas;
    private final List<Asistencia> asistencias = new ArrayList<>();

    public AcademiaService(AcademiaUCMusica academia, ReglaNegocio reglas) {
        this.academia = academia;
        this.reglas = reglas;
    }
        public AcademiaUCMusica getAcademia() {
        return academia;
    }

    @Override
    public boolean crearCurso(CursoInstrumento curso) {
        if (reglas.isConflictoHorario()) {
            for (CursoInstrumento c : academia.getCursos()) {
                if (c.getHorario().equals(curso.getHorario())) {
                    if (c.getProfesor() != null && curso.getProfesor() != null &&
                            c.getProfesor().getCedula().equals(curso.getProfesor().getCedula())) {
                        return false;
                    }
                    if (c.getAula() != null && curso.getAula() != null &&
                            c.getAula().equalsIgnoreCase(curso.getAula())) {
                        return false;
                    }
                }
            }
        }

        academia.agregarCurso(curso);
        return true;
    }

    @Override
    public boolean eliminarCurso(CursoInstrumento curso) {
        return academia.getCursos().remove(curso);
    }

    @Override
    public List<CursoInstrumento> listarCursos() {
        return Collections.unmodifiableList(academia.getCursos());
    }

    public boolean inscribirEstudianteEnCurso(Estudiante e, CursoInstrumento curso) {

        if (reglas.isPrerequisitosNivel()) {
            Nivel nivelNecesario = curso.getNivel();
            Nivel anterior = null;
            for (Nivel n : Nivel.values()) {
                if (n == nivelNecesario) break;
                anterior = n;
            }
        }

        if (!curso.tieneCupo()) return false;

        for (CursoInstrumento c : academia.getCursos()) {
            if (c.getInscritos().contains(e) && c.getHorario().equals(curso.getHorario())) {
                return false;
            }
        }

        boolean ok = curso.inscribir(e);
        if (ok) {
            if (!academia.getEstudiantes().contains(e)) academia.agregarEstudiante(e);
        }
        return ok;
    }

    @Override
    public Asistencia registrarAsistencia(Estudiante estudiante, CursoInstrumento curso, LocalDate fecha, boolean presente) {
        Asistencia a = new Asistencia(estudiante, curso, fecha, presente);
        asistencias.add(a);
        return a;
    }

    public List<Asistencia> listarAsistenciasPorCurso(CursoInstrumento curso) {
        return asistencias.stream().filter(a -> a.getCurso().equals(curso)).collect(Collectors.toList());
    }

    @Override
    public String generarReporteAsistencia(CursoInstrumento curso) {
        long total = asistencias.stream().filter(a -> a.getCurso().equals(curso)).count();
        long presentes = asistencias.stream().filter(a -> a.getCurso().equals(curso) && a.isPresente()).count();
        return String.format("Reporte Asistencia - %s: %d registros, %d presentes (%.2f%%)",
                curso, total, presentes, total == 0 ? 0.0 : (presentes * 100.0 / total));
    }

    @Override
    public String generarReporteProgreso(CursoTipo tipo, Nivel nivel) {
        List<CursoInstrumento> cursos = academia.getCursos().stream()
                .filter(c -> c.getTipo() == tipo && c.getNivel() == nivel)
                .collect(Collectors.toList());
        int inscritos = cursos.stream().mapToInt(c -> c.getInscritos().size()).sum();
        return String.format("Progreso %s %s: %d estudiantes inscritos en %d cursos",
                tipo, nivel, inscritos, cursos.size());
    }

    @Override
    public List<String> generarReporteCargaDocente() {
        Map<String, Long> carga = academia.getCursos().stream()
                .filter(c -> c.getProfesor() != null)
                .collect(Collectors.groupingBy(c -> c.getProfesor().getNombre(), Collectors.counting()));
        return carga.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue() + " cursos")
                .collect(Collectors.toList());
    }
}
