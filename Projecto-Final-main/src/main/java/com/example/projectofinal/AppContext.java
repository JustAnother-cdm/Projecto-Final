
package com.example.projectofinal;

import com.example.projectofinal.model.*;

public class AppContext {

    private static final AcademiaService SERVICE;

    static {
        AcademiaUCMusica academia = new AcademiaUCMusica("Academia UQ", "123456");
        ReglaNegocio reglas = new ReglaNegocio(10, true, true, 0, true);
        SERVICE = new AcademiaService(academia, reglas);

        // datos de ejemplo (opcional)
        Profesor p1 = new Profesor("Luis Maestro", "1001", java.time.LocalDate.of(1980,1,1), "Piano");
        SERVICE.getAcademia().agregarProfesor(p1);
    }

    public static AcademiaService getService() { return SERVICE; }
}
