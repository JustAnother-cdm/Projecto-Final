package com.example.projectofinal.ViewController;

import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Estudiante;
import com.example.projectofinal.model.ReglaNegocio;
import com.example.projectofinal.Controller.EstudianteController;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EstudianteViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;

    @FXML private ComboBox<CursoInstrumento> comboCursosDisponibles;
    @FXML private Label lblHorario;
    @FXML private Label lblAsistencia;
    @FXML private Label lblProgreso;

    private Estudiante estudiante;
    private EstudianteController controller = new EstudianteController();
    private ReglaNegocio reglas = new ReglaNegocio();

    @FXML
    public void registrarEstudiante() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        estudiante = new Estudiante(id, nombre, edad);
    }

    @FXML
    public void inscribirCurso() {
        CursoInstrumento curso = comboCursosDisponibles.getValue();

        boolean ok = controller.inscribirEstudianteEnCurso(estudiante, curso, reglas);

        if (ok) show("Estudiante inscrito exitosamente.");
        else show("No se puede inscribir: cupos o prerrequisitos fallan.");
    }

    @FXML
    public void mostrarHorario() {
        lblHorario.setText(controller.consultarHorario(estudiante));
    }

    @FXML
    public void mostrarProgreso() {
        CursoInstrumento curso = comboCursosDisponibles.getValue();
        lblProgreso.setText("Progreso: " + controller.consultarProgreso(estudiante, curso));
    }

    private void show(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.show();
    }
}