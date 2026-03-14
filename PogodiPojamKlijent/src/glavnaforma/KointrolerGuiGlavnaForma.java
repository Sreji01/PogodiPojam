/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glavnaforma;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Sreja
 */
public class KointrolerGuiGlavnaForma {

    FXMLGlavnaFormaController fxcon;

    public KointrolerGuiGlavnaForma(FXMLGlavnaFormaController fxcon) {
        this.fxcon = fxcon;

        this.fxcon.kreirajPartijuBtn.setOnAction(e -> {
            try {
                kreirajPartiju();
            } catch (Exception ex) {
                Logger.getLogger(KointrolerGuiGlavnaForma.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    private void kreirajPartiju() throws Exception {
        Partija partija = new Partija();
        if (fxcon.brojRundi.getText().equals("") || fxcon.kategorije.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Morate unteri broj rundi i izabrati zeljenu kategoriju pojmova!");
            alert.showAndWait();
        }

        int brojRundi;
        try {
            brojRundi = Integer.parseInt(fxcon.brojRundi.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Broj rundi mora biti ceo broj!");
            alert.showAndWait();
            return;
        }

        partija.setKorisnik(KontrolerKlijent.getInstance().getPrijavljeniKorisnik());
        partija.setBrojRundi(brojRundi);
        partija.setOdabranaKategorija((String) fxcon.kategorije.getValue());
        partija.setNazivPartije(generisiNazivPartije(partija));
        partija.setStatus("Kreirana");

        partija = KontrolerKlijent.getInstance().kreirajPartiju(partija);
        System.out.println(partija);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nova igra");
        alert.setHeaderText(null);
        alert.setContentText("Nova partija je uspešno kreirana!");
        alert.showAndWait();

        igra.JFXIgra igra = new igra.JFXIgra();
        Stage s = new Stage();
        igra.start(s);

        this.fxcon.closeStage();
    }

    private String generisiNazivPartije(Partija partija) {
        StringBuilder slova = new StringBuilder();
        for (int i = 1; i < partija.getKorisnik().getKorisnickoIme().length(); i += 2) {
            slova.append(partija.getKorisnik().getKorisnickoIme().charAt(i));
        }
        int broj = new Random().nextInt(9000) + 1000;
        return "P-" + slova.toString().toUpperCase() + "-" + broj;
    }
}
