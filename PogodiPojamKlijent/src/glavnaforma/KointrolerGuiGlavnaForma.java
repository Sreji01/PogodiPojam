/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glavnaforma;

import DomenskiObjekat.Partija;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Sreja
 */
public class KointrolerGuiGlavnaForma {

    FXMLGlavnaFormaController fxcon;

    public KointrolerGuiGlavnaForma(FXMLGlavnaFormaController fxcon) {
        this.fxcon = fxcon;
        ucitajPartije();
        this.fxcon.kreirajPartijuBtn.setOnAction(e -> {
            try {
                kreirajPartiju();
            } catch (Exception ex) {
                Logger.getLogger(KointrolerGuiGlavnaForma.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
        this.fxcon.zapocniPartijuBtn.setOnAction(e -> {
            try {
                zapocniPartiju();
            } catch (Exception ex) {
                Logger.getLogger(KointrolerGuiGlavnaForma.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    public void ucitajPartije() {
        try {
            Partija partija = new Partija();
            partija.setKorisnik(KontrolerKlijent.getInstance().getPrijavljeniKorisnik());
            List<Partija> partije = KontrolerKlijent.getInstance().ucitajPartije(partija);
            for (Partija p : partije) {
                fxcon.dodajPartijuUTabelu(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(KointrolerGuiGlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        partija.setNazivPartije(generisiNazivPartije());
        partija.setStatus("Kreirana");

        partija = KontrolerKlijent.getInstance().kreirajPartiju(partija);
        fxcon.dodajPartijuUTabelu(partija);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nova igra");
        alert.setHeaderText(null);
        alert.setContentText("Nova partija je uspesno kreirana!");
        alert.showAndWait();
    }

    private String generisiNazivPartije() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String slova = "" + alphabet.charAt(random.nextInt(26)) + alphabet.charAt(random.nextInt(26));
        int broj = random.nextInt(9000) + 1000;
        return "P-" + slova + "-" + broj;
    }

    private void zapocniPartiju() throws Exception {
        Partija partija = fxcon.getSelektovanaPartija();
        System.out.println(partija);

        if (partija == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Morate selektovati partiju iz tabele!");
            alert.showAndWait();
            return;
        }

        if (!partija.getStatus().equals("Kreirana")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Možete zapoceti samo partiju sa statusom 'Kreirana'!");
            alert.showAndWait();
            return;
        }
        
        partija = KontrolerKlijent.getInstance().zapocniPartiju(partija);
        System.out.println(partija);

        igra.JFXIgra igra = new igra.JFXIgra();
        igra.setPartija(partija);
        javafx.stage.Stage s = new javafx.stage.Stage();
        igra.start(s);
        fxcon.closeStage();
    }
}
