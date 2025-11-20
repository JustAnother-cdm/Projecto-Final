package com.example.projectofinal;

import com.example.projectofinal.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AdminController {

    @FXML private ComboBox<CursoTipo> comboTipoReporte;
    @FXML private ComboBox<Nivel> comboNivelReporte;
    @FXML private TextArea txtAreaReportes;

    private static final AcademiaService SERVICE = AppContext.getService();

    @FXML
    public void initialize() {
        comboTipoReporte.setItems(javafx.collections.FXCollections.observableArrayList(CursoTipo.values()));
        comboNivelReporte.setItems(javafx.collections.FXCollections.observableArrayList(Nivel.values()));
    }

    @FXML
    public void generarProgreso() {
        CursoTipo tipo = comboTipoReporte.getValue();
        Nivel nivel = comboNivelReporte.getValue();
        if (tipo == null || nivel == null) {
            show("Selecciona tipo y nivel");
            return;
        }
        String r = SERVICE.generarReporteProgreso(tipo, nivel);
        show(r);
    }

    @FXML
    public void generarCargaDocente() {
        List<String> r = SERVICE.generarReporteCargaDocente();
        show(String.join("\n", r));
    }

    private void show(String s) {
        txtAreaReportes.setText(s);
    }
}
