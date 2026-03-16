/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igra;

import DomenskiObjekat.Runda;
import java.io.ByteArrayInputStream;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author Sreja
 */
public class KontrolerGUIIgra {

    FXMLIgraController fxcon;
    List<Runda> runde;
    int trenutnaRunda = 0;

    public KontrolerGUIIgra(FXMLIgraController fxcon) {
        this.fxcon = fxcon;
        this.runde = fxcon.getPartija().getRunde();
        prikaziRundu(trenutnaRunda);

        fxcon.prethodnaBtn.setOnAction(e -> {
            trenutnaRunda--;
            prikaziRundu(trenutnaRunda);
        });

        fxcon.sledecaBtn.setOnAction(e -> {
            trenutnaRunda++;
            prikaziRundu(trenutnaRunda);
        });
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

        fxcon.prethodnaBtn.setDisable(index == 0);
        fxcon.sledecaBtn.setDisable(index == runde.size() - 1);
    }
}
