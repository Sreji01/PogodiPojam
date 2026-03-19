/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package korisnik;

import DomenskiObjekat.Korisnik;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Sreja
 */
public class KontrolerGUIKorisnik {

    FXMLKorisnikController fxcon;

    public KontrolerGUIKorisnik(FXMLKorisnikController fxcon) {
        this.fxcon = fxcon;

        this.fxcon.zapamtiBtn.setOnAction(e -> azurirajKorisnika());

    }

    private void azurirajKorisnika() {
        try {
            String trenutnaSifra = fxcon.trenutnaSifra.getText();
            String novaSifra = fxcon.novaSifra.getText();
            String ponovljenaSifra = fxcon.ponoviNovuSifru.getText();
            Korisnik ulogovaniKorisnik = KontrolerKlijent.getInstance().getPrijavljeniKorisnik();

            if (!ulogovaniKorisnik.getSifra().equals(trenutnaSifra)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Trenutna sifra nije ispravna!");
                alert.showAndWait();
                return;
            }

            if (!novaSifra.equals(ponovljenaSifra)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(null);
                alert.setContentText("Nova sifra i ponovljena sifra se ne poklapaju!");
                alert.showAndWait();
                return;
            }

            if (novaSifra.equals(trenutnaSifra)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Upozorenje");
                alert.setHeaderText(null);
                alert.setContentText("Nova sifra mora biti razlicita od trenutne sifre!");
                alert.showAndWait();
                return;
            }
            
            ulogovaniKorisnik.setSifra(novaSifra);
            KontrolerKlijent.getInstance().azurirajKorisnika(ulogovaniKorisnik);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspesno");
            alert.setHeaderText(null);
            alert.setContentText("Sifra je uspesno promenjena!");
            alert.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(KontrolerGUIKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerGUIKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
