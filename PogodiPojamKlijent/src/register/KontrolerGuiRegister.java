/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Sreja
 */
public class KontrolerGuiRegister {

    FXMLRegisterController fxcon;
    GenerickiKontrolerServer_Service service;
    GenerickiKontrolerServer generickiKontrolerServer;

    public KontrolerGuiRegister(FXMLRegisterController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;
        service = new GenerickiKontrolerServer_Service();
        generickiKontrolerServer = service.getGenerickiKontrolerServerPort();
        this.fxcon.registrujKorisnikaBtn.setOnAction(e -> registrujKorisnika(this.fxcon.ime.getText(), this.fxcon.prezime.getText(),
                this.fxcon.korisnickoIme.getText(), this.fxcon.sifra.getText()));
    }

    private void registrujKorisnika(String ime, String prezime, String korisnickoIme, String sifra) {
        try {
            generickiKontrolerServer.registrujKorisnika(ime, prezime, korisnickoIme, sifra);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspeh");
            alert.setHeaderText(null);
            alert.setContentText("Korisnik je registrovan!");
            alert.showAndWait();

            login.JFXLogin login = new login.JFXLogin();
            Stage s = new Stage();
            login.start(s);

        } catch (Exception ex) {
            Logger.getLogger(KontrolerGuiRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
