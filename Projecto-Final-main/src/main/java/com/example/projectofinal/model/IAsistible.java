package com.example.projectofinal.model;

import java.time.LocalDate;

public interface IAsistible {
    Asistencia registrarAsistencia(Estudiante estudiante, CursoInstrumento curso, LocalDate fecha, boolean presente);
}
