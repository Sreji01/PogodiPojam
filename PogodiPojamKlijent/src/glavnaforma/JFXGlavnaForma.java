/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glavnaforma;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sreja
 */
public class JFXGlavnaForma extends Application{

    FXMLGlavnaFormaController controller;
    private String korisnickoIme;

    public void setKorisnickoIme(String ime) {
        this.korisnickoIme = ime;
    }

    @Override
    public void start(Stage stage) throws Exception {

        String resourcePath = "FXMLGlavnaForma.fxml";
        URL location = getClass().getResource(resourcePath);
        System.out.println("location jfx " + location);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/glavnaforma/FXMLGlavnaForma.fxml"));

        Parent root = fxmlLoader.load();

        controller = (FXMLGlavnaFormaController) fxmlLoader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Ulogovani korisnik: " + korisnickoIme);
        stage.show();

    }
}
