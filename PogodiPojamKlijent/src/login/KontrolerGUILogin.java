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

        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Uspešna prijava");
        info.setHeaderText(null);
        info.setContentText("Korisnik je uspešno prijavljen!");
        info.showAndWait();

        glavnaforma.JFXGlavnaForma glavnaForma = new glavnaforma.JFXGlavnaForma();
        Stage s = new Stage();
        glavnaForma.setKorisnik(korisnik);
        glavnaForma.start(s);

        this.fxcon.closeStage();

    } catch (Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greška pri prijavi");
        alert.setHeaderText(null);
        alert.setContentText("Korisnik sa ovim kredencijalima ne postoji ili je već ulogovan.");
        alert.showAndWait();

        ex.printStackTrace();
    }
}

}
