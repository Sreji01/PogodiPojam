/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package glavnaforma;

import DomenskiObjekat.Partija;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sreja
 */
public class FXMLGlavnaFormaController {

    @FXML
    public Menu rezultati;
    @FXML
    public Menu izlaz;

    @FXML
    public MenuItem pogledajRangListu;
    @FXML
    public MenuItem izlazIzIgre;

    @FXML
    public ComboBox kategorije;

    @FXML
    public TextField brojRundi;

    @FXML
    public Button kreirajPartijuBtn;
    @FXML
    public Button zapocniPartijuBtn;

    @FXML
    private TableView<Partija> partije;

    @FXML
    private TableColumn<Partija, String> colVremePocetka;

    @FXML
    private TableColumn<Partija, String> colVremeZavrsetka;

    @FXML
    private TableColumn<Partija, String> colPrezime;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        kategorije.getItems().addAll("Sve", "Osobe", "Znamenitosti", "Bendovi", "Pop kultura");
        kategorije.setValue(null);
        KointrolerGuiGlavnaForma kngui = new KointrolerGuiGlavnaForma(this);
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
