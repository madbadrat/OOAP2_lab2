package ru.vorotov.ooap2_lab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SeeMyShrek extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SeeMyShrek.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 400);
        stage.setTitle("SHREEEEEEEEK");

        stage.getIcons().add(new Image(SeeMyShrek.class.getResourceAsStream("png-clipart-shrek-the-musical-princess-fiona-shrek-2-shrek-film-series-shrek-face-food.png")));

        stage.setScene(scene);
        stage.show();
    }
}