package com.example.projectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    private void openWindow(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML public void openEstudiantes() { openWindow("estudiante-view.fxml", "Estudiantes"); }
    @FXML public void openProfesores() { openWindow("profesor-view.fxml", "Profesores"); }
    @FXML public void openCursos() { openWindow("curso-view.fxml", "Cursos"); }
    @FXML public void openAdmin() { openWindow("admin-view.fxml", "Administrador"); }
}
