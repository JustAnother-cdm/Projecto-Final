package com.example.projectofinal;

import com.example.projectofinal.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CursoInstrumentoController {

    @FXML private ComboBox<CursoTipo> comboTipo;
    @FXML private ComboBox<Nivel> comboNivel;
    @FXML private TextField txtHorario;
    @FXML private TextField txtAula;
    @FXML private TextField txtCapacidad;
    @FXML private ComboBox<Profesor> comboProfesor;

    @FXML private TableView<CursoInstrumento> tablaInstrumentos;
    @FXML private TableColumn<CursoInstrumento, String> colTipo;
    @FXML private TableColumn<CursoInstrumento, String> colNivel;
    @FXML private TableColumn<CursoInstrumento, String> colHorario;
    @FXML private TableColumn<CursoInstrumento, String> colAula;
    @FXML private TableColumn<CursoInstrumento, String> colCapacidad;
    @FXML private TableColumn<CursoInstrumento, String> colProfesor;

    private final ObservableList<CursoInstrumento> lista = FXCollections.observableArrayList();
    private static final AcademiaService SERVICE = AppContext.getService();

    @FXML
    public void initialize() {
        comboTipo.setItems(FXCollections.observableArrayList(CursoTipo.values()));
        comboNivel.setItems(FXCollections.observableArrayList(Nivel.values()));
        comboProfesor.setItems(FXCollections.observableArrayList(SERVICE.getAcademia().getProfesores()));

        colTipo.setCellValueFactory(f -> new javafx.beans.property.SimpleStringProperty(f.getValue().getTipo().toString()));
        colNivel.setCellValueFactory(f -> new javafx.beans.property.SimpleStringProperty(f.getValue().getNivel().toString()));
        colHorario.setCellValueFactory(f -> new javafx.beans.property.SimpleStringProperty(f.getValue().getHorario()));
        colAula.setCellValueFactory(f -> new javafx.beans.property.SimpleStringProperty(f.getValue().getAula()));
        colCapacidad.setCellValueFactory(f -> new javafx.beans.property.SimpleStringProperty(String.valueOf(f.getValue().getCapacidad())));
        colProfesor.setCellValueFactory(f -> new javafx.beans.property.SimpleStringProperty(f.getValue().getProfesor() == null ? "" : f.getValue().getProfesor().getNombre()));

        lista.setAll(SERVICE.listarCursos());
        tablaInstrumentos.setItems(lista);
    }

    @FXML
    public void agregarInstrumento() {
        CursoTipo tipo = comboTipo.getValue();
        Nivel nivel = comboNivel.getValue();
        String horario = txtHorario.getText();
        String aula = txtAula.getText();
        int capacidad = 0;
        try {
            capacidad = Integer.parseInt(txtCapacidad.getText());
        } catch (NumberFormatException ex) {
            showAlert("Capacidad inválida", "Ingresa un número válido para la capacidad");
            return;
        }
        Profesor profesor = comboProfesor.getValue();

        if (tipo == null || nivel == null || horario.isEmpty() || aula.isEmpty() || capacidad <= 0) {
            showAlert("Faltan datos", "Completa la información del curso");
            return;
        }

        CursoInstrumento ci = new CursoInstrumento(tipo, nivel, horario, capacidad, aula, profesor);
        boolean ok = SERVICE.crearCurso(ci);
        if (!ok) showAlert("Error", "Conflicto de horario o aula con otro curso");
        else {
            lista.setAll(SERVICE.listarCursos());
            tablaInstrumentos.refresh();
            txtHorario.clear(); txtAula.clear(); txtCapacidad.clear();
            comboTipo.setValue(null); comboNivel.setValue(null); comboProfesor.setValue(null);
        }
    }

    private void showAlert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title); a.setHeaderText(null); a.setContentText(content); a.showAndWait();
    }
}
