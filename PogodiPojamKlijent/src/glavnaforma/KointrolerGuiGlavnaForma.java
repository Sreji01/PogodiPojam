/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glavnaforma;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import java.io.IOException;
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
        this.fxcon.detaljiPartijeBtn.setOnAction(e -> {
            try {
                ucitajPartiju();
            } catch (Exception ex) {
                Logger.getLogger(KointrolerGuiGlavnaForma.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
        this.fxcon.pogledajRangListu.setOnAction(e -> {
            otvoriRangListu();
        });

        this.fxcon.promeniSifru.setOnAction(e -> {
            try {
                azurirajKorisnika();
            } catch (Exception ex) {
                Logger.getLogger(KointrolerGuiGlavnaForma.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
        this.fxcon.obrisiNalog.setOnAction(e -> {
            try {
                obrisiKorisnika();
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
        if (fxcon.rundi5.isSelected() == false && fxcon.rundi10.isSelected() == false || fxcon.kategorije.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Morate izabrati broj rundi i izabrati zeljenu kategoriju pojmova!");
            alert.showAndWait();
            return;
        }

        int brojRundi = fxcon.getBrojRundi();

        Partija partija = new Partija();
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
        alert.setContentText("Partija je kreirana");
        alert.showAndWait();
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Greska");
        alert1.setHeaderText(null);
        alert1.setContentText("Ne moze da se kreira partija");
        alert1.showAndWait();
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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Partija zapoceta");
        alert.setHeaderText(null);
        alert.setContentText("Partija je zapoceta");
        alert.showAndWait();

        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Greska");
        alert1.setHeaderText(null);
        alert1.setContentText("Ne moze da se zapocne partija");
        alert1.showAndWait();

        igra.JFXIgra igra = new igra.JFXIgra();
        igra.setPartija(partija);
        javafx.stage.Stage s = new javafx.stage.Stage();
        igra.start(s);
        fxcon.closeStage();
    }

    private void ucitajPartiju() throws Exception {
        Partija partija = fxcon.getSelektovanaPartija();

        if (partija == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Upozorenje");
            alert.setHeaderText(null);
            alert.setContentText("Morate selektovati partiju iz tabele!");
            alert.showAndWait();
            return;
        }

        partija = KontrolerKlijent.getInstance().ucitajPartiju(partija);

        if (partija.getRezultat() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacije o partiji");
            alert.setHeaderText("Partija: " + partija.getNazivPartije());
            alert.setContentText("Ova partija jos uvek nema zabelezen rezultat (Status: " + partija.getStatus() + ").");
            alert.showAndWait();
            return;
        }

        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
        String pocetak = partija.getVremePocetka() != null ? partija.getVremePocetka().format(formatter) : "Nije zabelezeno";
        String kraj = partija.getVremeZavrsetka() != null ? partija.getVremeZavrsetka().format(formatter) : "Nije zabelezeno";

        StringBuilder sb = new StringBuilder();
        sb.append("Vreme pocetka: ").append(pocetak).append("\n");
        sb.append("Vreme zavrsetka: ").append(kraj).append("\n");
        sb.append("-----------------------------------\n");
        sb.append("Ukupan broj poena: ").append(partija.getRezultat().getUkupanBrojPoena()).append("\n");
        sb.append("Ukupan broj pokusaja: ").append(partija.getRezultat().getUkupanBrojPokusaja()).append("\n");

        int ukupnoSekundi = partija.getRezultat().getUkupnoVreme();
        int min = ukupnoSekundi / 60;
        int sek = ukupnoSekundi % 60;
        sb.append("Provedeno vreme: ").append(String.format("%02d:%02d", min, sek)).append(" (min:sek)");

        Alert detalji = new Alert(Alert.AlertType.INFORMATION);
        detalji.setTitle("Detalji zavrsene partije");
        detalji.setHeaderText("Statistika za partiju: " + partija.getNazivPartije());
        detalji.setContentText(sb.toString());

        detalji.getDialogPane().setMinWidth(400);

        detalji.showAndWait();
    }

    private void otvoriRangListu() {
        try {
            ranglista.JFXRangLista rangLista = new ranglista.JFXRangLista();

            rangLista.setKorisnik(KontrolerKlijent.getInstance().getPrijavljeniKorisnik());

            javafx.stage.Stage stage = new javafx.stage.Stage();

            rangLista.start(stage);

        } catch (Exception ex) {
            Logger.getLogger(KointrolerGuiGlavnaForma.class.getName())
                    .log(Level.SEVERE, "Greska pri otvaranju rang liste", ex);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Neuspesno otvaranje rang liste");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    private void azurirajKorisnika() throws Exception {
        korisnik.JFXKorisnik korisnik = new korisnik.JFXKorisnik();
        javafx.stage.Stage s = new javafx.stage.Stage();
        korisnik.start(s);
    }

    private void obrisiKorisnika() throws IOException {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Potvrda");
        confirm.setHeaderText("Brisanje naloga");
        confirm.setContentText("Da li ste sigurni da zelite da obrisete nalog?");

        java.util.Optional<javafx.scene.control.ButtonType> result = confirm.showAndWait();

        Korisnik korisnik = KontrolerKlijent.getInstance().getPrijavljeniKorisnik();

        if (result.isPresent() && result.get() == javafx.scene.control.ButtonType.OK) {
            try {
                //KontrolerKlijent.getInstance().obrisiKorisnika(korisnik);

                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("Uspesno");
                info.setHeaderText(null);
                info.setContentText("Korisnik je obrisan.");
                info.showAndWait();
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Greska");
                alert1.setHeaderText(null);
                alert1.setContentText("Ne moze da se obrise korisnik");
                alert1.showAndWait();

                fxcon.closeStage();
            } catch (Exception ex) {
                Logger.getLogger(KointrolerGuiGlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
