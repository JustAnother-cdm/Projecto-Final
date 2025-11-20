package com.example.projectofinal.model;

import java.util.List;

public interface ICursoGestionable {
    boolean crearCurso(CursoInstrumento curso);
    boolean eliminarCurso(CursoInstrumento curso);
    List<CursoInstrumento> listarCursos();
}
