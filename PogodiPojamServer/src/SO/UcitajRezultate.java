/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Rezultat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sreja
 */
public class UcitajRezultate extends SystemOperation {

    List<Rezultat> rezultati;

    @Override
    protected void validate(Object entity) throws Exception {
    }

    @Override
    protected void execute(Object entity) throws Exception {
        rezultati = (List<Rezultat>) (ArrayList<?>) databaseBroker.selectMany((Rezultat) entity);
    }

    public List<Rezultat> vratiRezultate() {
        return rezultati;
    }

}
