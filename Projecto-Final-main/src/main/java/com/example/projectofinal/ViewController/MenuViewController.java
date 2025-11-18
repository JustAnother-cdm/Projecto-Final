package com.example.projectofinal.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

public class MenuViewController {

    @FXML private Label lblRol;
    @FXML private Button btnEstudiante;
    @FXML private Button btnProfesor;
    @FXML private Button btnAdministrador;

    private String rolUsuario;

    public void setRol(String rol) {
        this.rolUsuario = rol;
        lblRol.setText("Rol actual: " + rol);

        // ocultar/mostrar opciones según el rol
        btnEstudiante.setVisible(rol.equals("Estudiante"));
        btnProfesor.setVisible(rol.equals("Profesor"));
        btnAdministrador.setVisible(rol.equals("Administrador"));
    }

    @FXML
    public void abrirEstudiante() { cargarVista("estudiante-view.fxml"); }

    @FXML
    public void abrirProfesor() { cargarVista("profesor-view.fxml"); }

    @FXML
    public void abrirAdministrador() { cargarVista("administrador-view.fxml"); }

    private void cargarVista(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projectofinal/" + fxml));
            Stage stage = (Stage) lblRol.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "No se pudo abrir la vista.").show();
        }
    }
}