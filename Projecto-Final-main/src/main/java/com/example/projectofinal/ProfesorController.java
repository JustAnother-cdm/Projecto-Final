package com.example.projectofinal;

import com.example.projectofinal.model.Profesor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProfesorController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCedula;
    @FXML private TextField txtEsp;
    @FXML private DatePicker dateNacimiento;

    @FXML private TableView<Profesor> tablaProfesores;
    @FXML private TableColumn<Profesor, String> colNombre;
    @FXML private TableColumn<Profesor, String> colCedula;
    @FXML private TableColumn<Profesor, String> colEspecialidad;

    private final ObservableList<Profesor> lista =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(e -> e.getValue().nombreProperty());
        colCedula.setCellValueFactory(e -> e.getValue().cedulaProperty());
        colEspecialidad.setCellValueFactory(e -> e.getValue().especialidadProperty());

        tablaProfesores.setItems(lista);
    }

    @FXML
    public void agregarProfesor() {

        Profesor p = new Profesor(
                txtNombre.getText(),
                txtCedula.getText(),
                dateNacimiento.getValue(),
                txtEsp.getText()
        );

        lista.add(p);

        txtNombre.clear();
        txtCedula.clear();
        txtEsp.clear();
        dateNacimiento.setValue(null);
    }
}
