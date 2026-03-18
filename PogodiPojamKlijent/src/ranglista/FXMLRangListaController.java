/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ranglista;

import DomenskiObjekat.Rezultat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class FXMLRangListaController {

    KontrolerGuiRangLista kngui;
    @FXML
    ComboBox<String> kategorije;
    @FXML
    TextField brojRundi;
    @FXML
    Button pretraziBtn;
    @FXML
    Button restartujBtn;
    @FXML
    Button nazad;
    @FXML
    TableView<Rezultat> rezultati;
    @FXML
    private TableColumn<Rezultat, Integer> colRang;
    @FXML
    private TableColumn<Rezultat, String> colNaziv;
    @FXML
    private TableColumn<Rezultat, Integer> colBrojRundi;
    @FXML
    private TableColumn<Rezultat, String> colKategorija;
    @FXML
    private TableColumn<Rezultat, Integer> colBrojPoena;
    @FXML
    private TableColumn<Rezultat, Integer> colBrojPokusaja;
    @FXML
    private TableColumn<Rezultat, String> colProvedenoVreme;
    @FXML
    private TableColumn<Rezultat, String> colKorisnik;

    public KontrolerGuiRangLista getKontroler() {
        return kngui;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        colBrojPoena.setCellValueFactory(new PropertyValueFactory<>("ukupanBrojPoena"));
        colBrojPokusaja.setCellValueFactory(new PropertyValueFactory<>("ukupanBrojPokusaja"));

        colRang.setCellValueFactory(cellData -> {
            int index = rezultati.getItems().indexOf(cellData.getValue()) + 1;
            return new javafx.beans.property.SimpleObjectProperty<>(index);
        });

        colProvedenoVreme.setCellValueFactory(cellData -> {
            int ukupnoSekundi = cellData.getValue().getUkupnoVreme();
            int min = ukupnoSekundi / 60;
            int sek = ukupnoSekundi % 60;
            return new javafx.beans.property.SimpleStringProperty(String.format("%02d:%02d", min, sek));
        });

        colNaziv.setCellValueFactory(cellData
                -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPartija().getNazivPartije()));

        colKategorija.setCellValueFactory(cellData
                -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPartija().getOdabranaKategorija()));

        colBrojRundi.setCellValueFactory(cellData
                -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPartija().getBrojRundi()));
        
        colKorisnik.setCellValueFactory(cellData
                -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPartija().getKorisnik().getKorisnickoIme()));

        kategorije.getItems().addAll("Sve", "Osobe", "Znamenitosti", "Bendovi", "Pop kultura");
        kategorije.setValue(null);
        kngui = new KontrolerGuiRangLista(this);
        kngui.ucitajRezultate();
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
