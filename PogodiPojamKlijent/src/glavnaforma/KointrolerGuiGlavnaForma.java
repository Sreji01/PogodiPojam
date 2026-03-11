/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glavnaforma;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import java.io.IOException;
import java.time.LocalDateTime;
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

        this.fxcon.zapocniIgru.setOnAction(e -> {
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
        partija.setVremePocetka(LocalDateTime.now());
        partija = KontrolerKlijent.getInstance().kreirajPartiju(partija);
        System.out.println(partija);

        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Nova igra");
        info.setContentText("Nova partija je uspešno kreirana!");
        info.showAndWait();
    }

}
