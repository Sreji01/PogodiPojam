package igra;

import DomenskiObjekat.Partija;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLIgraController {

    Partija partija;
    KontrolerGUIIgra kngui;

    @FXML
    public ImageView slika;
    
    @FXML
    public Button prethodnaBtn;
    @FXML
    public Button sledecaBtn;
    @FXML
    public Button zpaamtiBtn;
    @FXML
    public Button odustaniBtn;
    @FXML
    public TextField pojam;
    @FXML
    public Label brojPokusaja;
    @FXML
    public Label potBrojPoena;
    @FXML
    public Label brojPoena;
    @FXML
    public Label tajmer;
    @FXML
    public Label ukupanBrojPoena;
    

    @FXML
    public void initialize() {
    }

    public void setPartija(Partija partija) {
        this.partija = partija;
        try {
            kngui = new KontrolerGUIIgra(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Partija getPartija() {
        return partija;
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }
}
