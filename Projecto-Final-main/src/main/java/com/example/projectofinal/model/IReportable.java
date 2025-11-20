package com.example.projectofinal.model;

import java.util.List;

public interface IReportable {
    String generarReporteAsistencia(CursoInstrumento curso);
    String generarReporteProgreso(CursoTipo tipo, Nivel nivel);
    List<String> generarReporteCargaDocente();
}
