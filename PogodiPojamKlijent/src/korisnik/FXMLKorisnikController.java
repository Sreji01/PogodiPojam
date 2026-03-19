/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package korisnik;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sreja
 */
public class FXMLKorisnikController {
    
    @FXML
    public TextField trenutnaSifra;
    @FXML
    public TextField novaSifra;
    @FXML
    public TextField ponoviNovuSifru;
    @FXML
    public Button zapamtiBtn;
    @FXML
    public Button odustaniBtn;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        KontrolerGUIKorisnik kngui = new KontrolerGUIKorisnik(this);
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
