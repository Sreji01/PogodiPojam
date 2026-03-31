package igra;

import DomenskiObjekat.Partija;
import DomenskiObjekat.Rezultat;
import DomenskiObjekat.Runda;
import glavnaforma.JFXGlavnaForma;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.util.Duration;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.KontrolerKlijent;

public class KontrolerGUIIgra {

    FXMLIgraController fxcon;
    List<Runda> runde;
    int trenutnaRunda = 0;
    Timeline tajmer;
    int sekunde = 0;

    public KontrolerGUIIgra(FXMLIgraController fxcon) {
        this.fxcon = fxcon;
        this.runde = fxcon.getPartija().getRunde();

        for (Runda r : runde) {
            if (!r.isPogodjeno()) {
                r.setBrojPoena(5);
            }
        }

        prikaziRundu(trenutnaRunda);
        pokrniTajmer();
        azurirajUkupanBrojPoena();

        fxcon.prethodnaBtn.setOnAction(e -> {
            trenutnaRunda--;
            prikaziRundu(trenutnaRunda);
        });
        fxcon.sledecaBtn.setOnAction(e -> {
            trenutnaRunda++;
            prikaziRundu(trenutnaRunda);
        });
        fxcon.zpaamtiBtn.setOnAction(e -> {
            proveriOdgovor();
        });
        fxcon.odustaniBtn.setOnAction(e -> {
            Alert potvrda = new Alert(Alert.AlertType.CONFIRMATION);
            potvrda.setTitle("Odustajanje");
            potvrda.setHeaderText(null);
            potvrda.setContentText("Da li ste sigurni da zelite da odustanete od partije?");
            Optional<ButtonType> rezultat = potvrda.showAndWait();
            if (rezultat.isPresent() && rezultat.get() == ButtonType.OK) {
                zavrsiPartiju(false);
            }
        });
    }

    private void pokrniTajmer() {
        if (fxcon.tajmer == null) {
            System.out.println("GRESKA: Label 'tajmer' nije injektovan iz FXML-a. Proveri fx:id.");
            return;
        }
        fxcon.tajmer.setText("00:00");
        tajmer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            sekunde++;
            int min = sekunde / 60;
            int sek = sekunde % 60;
            fxcon.tajmer.setText(String.format("%02d:%02d", min, sek));
        }));
        tajmer.setCycleCount(Timeline.INDEFINITE);
        tajmer.play();
    }

    private void proveriOdgovor() {
        Runda runda = runde.get(trenutnaRunda);
        String unos = fxcon.pojam.getText().trim();
        String tacanOdgovor = runda.getTacanOdgovor();

        runda.setBrojPokusaja(runda.getBrojPokusaja() + 1);

        if (unos.equalsIgnoreCase(tacanOdgovor)) {
            runda.setPogodjeno(true);

            azurirajLabele();
            azurirajUkupanBrojPoena();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tacno!");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Tacan odgovor: " + tacanOdgovor + "\n"
                    + "Broj poena: " + runda.getBrojPoena() + "\n"
                    + "Broj pokusaja: " + runda.getBrojPokusaja()
            );
            alert.showAndWait();

            boolean svePogodjeno = runde.stream().allMatch(Runda::isPogodjeno);

            if (svePogodjeno) {
                zavrsiPartiju(true);
            } else if (trenutnaRunda < runde.size() - 1) {
                trenutnaRunda++;
                prikaziRundu(trenutnaRunda);
            }
        } else {
            if (runda.getBrojPoena() > 1) {
                runda.setBrojPoena(runda.getBrojPoena() - 1);
            }

            azurirajUkupanBrojPoena();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Netacno");
            alert.setHeaderText(null);
            alert.setContentText("Pokusaj ponovo! Pokusaj br. " + runda.getBrojPokusaja());
            alert.showAndWait();

            fxcon.pojam.clear();
            azurirajLabele();
        }
    }

    private void zavrsiPartiju(boolean uspesno) {
        try {
            if (tajmer != null) {
                tajmer.stop();
            }

            int ukupnoPoena = runde.stream()
                    .filter(Runda::isPogodjeno)
                    .mapToInt(Runda::getBrojPoena)
                    .sum();

            int ukupnoPokusaja = runde.stream()
                    .mapToInt(Runda::getBrojPokusaja)
                    .sum();

            Partija partija = fxcon.getPartija();
            Rezultat rezultat = new Rezultat(null, ukupnoPoena, ukupnoPokusaja, sekunde, partija);
            partija.setRezultat(rezultat);
            partija.setStatus("Zavrsena");
            partija.setVremeZavrsetka(java.time.LocalDateTime.now());

            KontrolerKlijent.getInstance().zavrsiPartiju(partija);

            Alert krajAlert = new Alert(Alert.AlertType.INFORMATION);
            krajAlert.setTitle(uspesno ? "Kraj igre" : "Odustajanje");
            krajAlert.setHeaderText(null);

            if (uspesno) {
                krajAlert.setContentText(
                        "Partija je zaversena\n"
                        + "Ukupno ostvarenih poena: " + ukupnoPoena + "\n"
                        + "Ukupno pokusaja: " + ukupnoPokusaja + "\n"
                        + "Vreme: " + fxcon.tajmer.getText()
                );
            } else {
                krajAlert.setContentText(
                        "Partija je zavrsena.\n"
                        + "Ukupno ostvarenih poena: " + ukupnoPoena + "\n"
                        + "Ukupno pokusaja: " + ukupnoPokusaja + "\n"
                        + "Vreme: " + fxcon.tajmer.getText()
                );
            }

            krajAlert.showAndWait();

            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Greska");
            alert1.setHeaderText(null);
            alert1.setContentText("Ne moze da se zavrsi partija");
            alert1.showAndWait();
            try {
                JFXGlavnaForma glavnaForma = new JFXGlavnaForma();
                glavnaForma.setKorisnik(fxcon.getPartija().getKorisnik());
                javafx.stage.Stage s = new javafx.stage.Stage();
                glavnaForma.start(s);
            } catch (Exception ex) {
                Logger.getLogger(KontrolerGUIIgra.class.getName()).log(Level.SEVERE, null, ex);
            }

            fxcon.closeStage();
        } catch (IOException ex) {
            Logger.getLogger(KontrolerGUIIgra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerGUIIgra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prikaziRundu(int index) {
        Runda runda = runde.get(index);
        byte[] slikaBytes = runda.getPojam().getSlika();
        if (slikaBytes != null) {
            Image image = new Image(new ByteArrayInputStream(slikaBytes));
            fxcon.slika.setImage(image);
        } else {
            fxcon.slika.setImage(null);
        }

        fxcon.pojam.clear();
        fxcon.prethodnaBtn.setDisable(index == 0);
        fxcon.sledecaBtn.setDisable(index == runde.size() - 1);
        azurirajLabele();
    }

    private void azurirajLabele() {
        Runda runda = runde.get(trenutnaRunda);

        fxcon.brojPokusaja.setText(String.valueOf(runda.getBrojPokusaja()));

        if (runda.isPogodjeno()) {
            fxcon.potBrojPoena.setText("Ostvareni broj poena");
            fxcon.brojPoena.setText(String.valueOf(runda.getBrojPoena()));
            fxcon.zpaamtiBtn.setDisable(true);
            fxcon.pojam.setDisable(true);
        } else {
            fxcon.potBrojPoena.setText("Potencijalni broj poena");
            fxcon.brojPoena.setText(String.valueOf(runda.getBrojPoena()));
            fxcon.zpaamtiBtn.setDisable(false);
            fxcon.pojam.setDisable(false);
        }
    }

    private void azurirajUkupanBrojPoena() {
        if (fxcon.ukupanBrojPoena == null) {
            System.out.println("GRESKA: Label 'ukupanBrojPoena' nije injektovan iz FXML-a. Proveri fx:id.");
            return;
        }
        int ukupno = runde.stream()
                .filter(Runda::isPogodjeno)
                .mapToInt(Runda::getBrojPoena)
                .sum();
        fxcon.ukupanBrojPoena.setText(String.valueOf(ukupno));
    }
}
