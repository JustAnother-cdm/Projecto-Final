package com.example.projectofinal.ViewController;

import com.example.projectofinal.model.CursoInstrumento;
import com.example.projectofinal.model.Profesor;
import com.example.projectofinal.Controller.ProfesorController;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProfesorViewController {

    @FXML private TextField txtIdProf;
    @FXML private TextField txtNombreProf;
    @FXML private TextField txtHorarioNuevo;

    @FXML private ComboBox<CursoInstrumento> comboCursosProfesor;
    @FXML private TextField txtIdEstudiante;

    @FXML private TextField txtValoracion;

    private Profesor profesor;
    private ProfesorController Controller = new ProfesorController();

    @FXML
    public void registrarProfesor() {
        profesor = new Profesor(txtIdProf.getText(), txtNombreProf.getText());
    }

    @FXML
    public void agregarHorario() {
        Controller.agregarHorarioDisponible(profesor, txtHorarioNuevo.getText());
        show("Horario agregado.");
    }

    @FXML
    public void crearClaseGrupal() {
        CursoInstrumento curso = comboCursosProfesor.getValue();
        boolean ok = Controller.crearClaseGrupal(profesor, curso, txtHorarioNuevo.getText());
        show(ok ? "Clase creada." : "Horario no disponible.");
    }

    @FXML
    public void registrarAsistencia() {
        Controller.registrarAsistencia(comboCursosProfesor.getValue(), txtIdEstudiante.getText());
        show("Asistencia registrada.");
    }

    @FXML
    public void registrarValoracion() {
        double v = Double.parseDouble(txtValoracion.getText());
        Controller.registrarProgreso(comboCursosProfesor.getValue(), txtIdEstudiante.getText(), v);
        show("Valoración agregada.");
    }

    private void show(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }
}
