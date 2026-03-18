/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ranglista;

import DomenskiObjekat.Korisnik;
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
public class JFXRangLista extends Application{

    FXMLRangListaController controller;
    private Korisnik korisnik;

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public void start(Stage stage) throws Exception {

        String resourcePath = "FXMLRangLista.fxml";
        URL location = getClass().getResource(resourcePath);
        System.out.println("location jfx " + location);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ranglista/FXMLRangLista.fxml"));

        Parent root = fxmlLoader.load();

        controller = (FXMLRangListaController) fxmlLoader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Ulogovani korisnik: " + korisnik.getKorisnickoIme());
        stage.show();
    }
}
