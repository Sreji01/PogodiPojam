/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igra;

import login.*;
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
public class JFXIgra extends Application {

    FXMLIgraController con;
    private DomenskiObjekat.Partija partija;

    public void setPartija(DomenskiObjekat.Partija partija) {
        this.partija = partija;
    }

    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLIgra.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLIgraController) fxmlLoader.getController();
        con.setStage(stage);
        con.setPartija(partija);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Igra");
        stage.show();
    }
}
