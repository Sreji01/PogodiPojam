/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igra;

import login.*;
import DomenskiObjekat.Korisnik;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Sreja
 */
public class KontrolerGUIIgra {
    
    FXMLIgraController fxcon;
    
    public KontrolerGUIIgra(FXMLIgraController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;
    }

}
