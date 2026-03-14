/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package igra;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sreja
 */
public class FXMLIgraController {

    @FXML
    public void initialize() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        KontrolerGUIIgra kngui = new KontrolerGUIIgra(this);
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }
    
}
