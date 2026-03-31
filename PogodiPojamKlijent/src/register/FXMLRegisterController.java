/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package register;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sreja
 */
public class FXMLRegisterController {

    @FXML
    public TextField ime;

    @FXML
    public TextField prezime;

    @FXML
    public TextField korisnickoIme;
    
    @FXML
    public PasswordField sifra;
    
    @FXML
    public Button registrujKorisnikaBtn;

    /**
     * Initializes the controller class.
     */
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        KontrolerGuiRegister kngui = new KontrolerGuiRegister(this);
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
