/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import DomenskiObjekat.Korisnik;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Sreja
 */
public class KontrolerGUILogin {

    FXMLLoginController fxcon;

    public KontrolerGUILogin(FXMLLoginController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;
        this.fxcon.prijavaBtn.setOnAction(e -> prijaviKorisnika(this.fxcon.korisnickoIme.getText(), this.fxcon.sifra.getText()));

    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void prijaviKorisnika(String korisnickoIme, String sifra) {
        try {

            Korisnik korisnik = KontrolerKlijent.getInstance().prijaviKorisnika(korisnickoIme, sifra);

            glavnaforma.JFXGlavnaForma glavnaForma;

            Stage s;
            glavnaForma = new glavnaforma.JFXGlavnaForma();
            s = new Stage();
            glavnaForma.setKorisnickoIme(korisnik.getKorisnickoIme());
            glavnaForma.start(s);

            this.fxcon.closeStage();
        } catch (Exception ex) {
            poruka("Korisnik sa ovim kredencijalima ne postoji u sistemu ili je vec ulogovan");
            ex.printStackTrace();
        }
    }

}
