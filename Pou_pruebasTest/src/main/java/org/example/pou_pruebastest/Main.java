package org.example.pou_pruebastest;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/org/example/pou_pruebastest/vista.fxml")
            );

            Parent root = loader.load();

            Controlador controller = loader.getController();

            Modelo modelo = new Modelo("Pou", 80, 80, 80, 50);

            controller.setModelo(modelo);

            Scene scene = new Scene(root, 320, 500);

            stage.setTitle("Juego Pou 🐾");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}