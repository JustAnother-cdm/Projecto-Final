package com.example.projectofinal;

import com.example.projectofinal.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class EstudianteController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCedula;

    @FXML private ComboBox<Estudiante> comboEstudiantes;
    @FXML private ComboBox<CursoInstrumento> comboCursos;

    @FXML private TableView<Estudiante> tablaEstudiantes;
    @FXML private TableColumn<Estudiante, String> colNombre;
    @FXML private TableColumn<Estudiante, String> colCedula;
    @FXML private TableColumn<Estudiante, String> colCurso;

    private final ObservableList<Estudiante> lista =
            FXCollections.observableArrayList();

    private final ObservableList<CursoInstrumento> listaCursos =
            FXCollections.observableArrayList();

    // Servicio central compartido
    private static final AcademiaService SERVICE = AppContext.getService();

    @FXML
    public void initialize() {

        // Se cargan estudiantes y cursos
        lista.setAll(SERVICE.getAcademia().getEstudiantes());
        listaCursos.setAll(SERVICE.listarCursos());

        comboEstudiantes.setItems(lista);
        comboCursos.setItems(listaCursos);

        // Configurar columnas
        colNombre.setCellValueFactory(e ->
                new javafx.beans.property.SimpleStringProperty(e.getValue().getNombre()));

        colCedula.setCellValueFactory(e ->
                new javafx.beans.property.SimpleStringProperty(e.getValue().getCedula()));

        colCurso.setCellValueFactory(e -> {
            String cursos = SERVICE.getAcademia().getCursos().stream()
                    .filter(c -> c.getInscritos().contains(e.getValue()))
                    .map(CursoInstrumento::toString)
                    .collect(Collectors.joining("; "));
            return new javafx.beans.property.SimpleStringProperty(cursos);
        });

        tablaEstudiantes.setItems(lista);
    }

    @FXML
    public void crearEstudiante() {

        Estudiante e = new Estudiante(
                txtNombre.getText(),
                txtCedula.getText(),
                LocalDate.now(),
                "SIN",
                ""
        );

        SERVICE.getAcademia().agregarEstudiante(e);

        lista.setAll(SERVICE.getAcademia().getEstudiantes());
        comboEstudiantes.setItems(lista);

        txtNombre.clear();
        txtCedula.clear();
    }

    @FXML
    public void inscribirSeleccion() {

        Estudiante e = comboEstudiantes.getValue();
        CursoInstrumento c = comboCursos.getValue();

        if (e == null || c == null) {
            showAlert("Faltan datos", "Selecciona estudiante y curso");
            return;
        }

        boolean ok = SERVICE.inscribirEstudianteEnCurso(e, c);

        if (!ok) {
            showAlert("Inscripción fallida",
                    "No se pudo inscribir. Revise cupo, horario o prerrequisitos.");
        } else {
            lista.setAll(SERVICE.getAcademia().getEstudiantes());
            tablaEstudiantes.refresh();
            showAlert("Inscripción exitosa", "Estudiante inscrito correctamente.");
        }
    }

    private void showAlert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(content);
        a.showAndWait();
    }
}
