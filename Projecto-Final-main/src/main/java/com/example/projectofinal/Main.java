package com.example.projectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(Main.class.getResource("/com/example/projectofinal/Main.fxml"));
        Scene scene = new Scene(fxml.load());
        stage.setScene(scene);
        stage.setTitle("Academia Música UQ");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
