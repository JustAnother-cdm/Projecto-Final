package com.example.projectofinal.ViewController;

import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Estudiante;
import com.example.projectofinal.model.Profesor;
import com.example.projectofinal.Controller.AdministradorController;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AdministradorViewController {

    @FXML private TextField txtInstCurso;
    @FXML private TextField txtNivelCurso;
    @FXML private TextField txtAula;

    @FXML private ComboBox<Estudiante> comboEstudiantes;
    @FXML private ComboBox<Profesor> comboProfesores;

    @FXML private Label lblReporte;

    private AdministradorController controller = new AdministradorController();

    private List<CursoInstrumento> listaCursos;

    @FXML
    public void crearCurso() {
        String inst = txtInstCurso.getText();
        int nivel = Integer.parseInt(txtNivelCurso.getText());
        String aula = txtAula.getText();

        CursoInstrumento curso = controller.crearCurso(inst, nivel, aula);
        listaCursos.add(curso);

        show("Curso creado.");
    }

    @FXML
    public void modificarEstudiante() {
        Estudiante e = comboEstudiantes.getValue();
        boolean ok = controller.modificarEstudiante(comboEstudiantes.getItems(), e);
        show(ok ? "Estudiante modificado." : "No encontrado.");
    }

    @FXML
    public void modificarProfesor() {
        Profesor p = comboProfesores.getValue();
        boolean ok = controller.modificarProfesor(comboProfesores.getItems(), p);
        show(ok ? "Profesor modificado." : "No encontrado.");
    }

    @FXML
    public void reporteOcupacion() {
        lblReporte.setText(controller.reporteOcupacionAulas(listaCursos));
    }

    private void show(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }
}
