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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Partija, String> colNaziv;
    @FXML
    private TableColumn<Partija, String> colKategorija;
    @FXML
    private TableColumn<Partija, Integer> colBrojRundi;
    @FXML
    private TableColumn<Partija, String> colStatus;

    @FXML
    public void initialize() {
        kategorije.getItems().addAll("Sve", "Osobe", "Znamenitosti", "Bendovi", "Pop kultura");
        kategorije.setValue(null);

        colNaziv.setCellValueFactory(new PropertyValueFactory<>("nazivPartije"));
        colKategorija.setCellValueFactory(new PropertyValueFactory<>("odabranaKategorija"));
        colBrojRundi.setCellValueFactory(new PropertyValueFactory<>("brojRundi"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        KointrolerGuiGlavnaForma kngui = new KointrolerGuiGlavnaForma(this);
    }

    public void dodajPartijuUTabelu(Partija partija) {
        partije.getItems().add(partija);
    }

    public Partija getSelektovanaPartija() {
        return partije.getSelectionModel().getSelectedItem();
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
