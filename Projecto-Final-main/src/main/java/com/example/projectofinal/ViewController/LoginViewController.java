package com.example.projectofinal.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginViewController {

    @FXML private ComboBox<String> comboRol;
    @FXML private Button btnIngresar;
    @FXML private Label lblError;

    @FXML
    public void initialize() {
        comboRol.getItems().addAll("Estudiante", "Profesor", "Administrador");
    }

    @FXML
    public void ingresar() {
        String rol = comboRol.getValue();

        if (rol == null) {
            lblError.setText("Selecciona un rol.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectofinal/menu-view.fxml"));
            Parent root = loader.load();

            MenuViewController controller = loader.getController();
            controller.setRol(rol);

            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Error al cargar vista de menú").show();
        }
    }
}