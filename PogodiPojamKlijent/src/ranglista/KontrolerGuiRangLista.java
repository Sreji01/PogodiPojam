/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ranglista;

import DomenskiObjekat.Partija;
import DomenskiObjekat.Rezultat;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Sreja
 */
public class KontrolerGuiRangLista {

    FXMLRangListaController fxcon;

    public KontrolerGuiRangLista(FXMLRangListaController fxcon) {
        this.fxcon = fxcon;

        fxcon.pretraziBtn.setOnAction(e -> {
            try {
                pretraziRezultate();
            } catch (IOException ex) {
                Logger.getLogger(KontrolerGuiRangLista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(KontrolerGuiRangLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        fxcon.nazad.setOnAction(e -> {
            fxcon.closeStage();
        });

        fxcon.restartujBtn.setOnAction(e -> {
            restartujPolja();
        });
    }

    void ucitajRezultate() {
        try {
            List<Rezultat> lista = KontrolerKlijent.getInstance().ucitajRezultate();

            fxcon.rezultati.getItems().clear();
            fxcon.rezultati.getItems().addAll(lista);

        } catch (Exception ex) {
            Logger.getLogger(KontrolerGuiRangLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pretraziRezultate() throws IOException, Exception {
        String kategorija = fxcon.kategorije.getValue();
        int brojRundi = fxcon.getBrojRundi();

        if (kategorija == null && brojRundi == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Morate uneti barem jedan kriterijum pretrage!\nOdaberite kategoriju ili izaberite broj rundi.");
            alert.showAndWait();
            return;
        }

        Partija partija = new Partija();
        partija.setOdabranaKategorija(kategorija);
        partija.setBrojRundi(brojRundi == -1 ? 0 : brojRundi);

        Rezultat rezultat = new Rezultat();
        rezultat.setPartija(partija);

        List<Rezultat> lista = KontrolerKlijent.getInstance().pretraziRezultate(rezultat);
        lista.sort((a, b) -> Integer.compare(b.getUkupanBrojPoena(), a.getUkupanBrojPoena()));
        fxcon.rezultati.getItems().clear();

        if (lista.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nema rezultata");
            alert.setHeaderText(null);
            alert.setContentText("Rezultati nisu pronadjeni");
            alert.showAndWait();
            return;
        }

        fxcon.rezultati.getItems().addAll(lista);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pretraga uspesna");
        alert.setHeaderText(null);
        alert.setContentText("Rezultati su pronadjeni");
        alert.showAndWait();
    }

    private void restartujPolja() {
        ucitajRezultate();
        fxcon.kategorije.setValue(null);
        fxcon.rundi5.setSelected(false);
        fxcon.rundi10.setSelected(false);
    }
}
