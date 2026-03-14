/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Partija;
import DomenskiObjekat.Runda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sreja
 */
public class ZapocniPartiju extends SystemOperation{
    Partija partija;

    @Override
    protected void validate(Object entity) throws Exception {
    }

    @Override
    protected void execute(Object entity) throws Exception {
        partija = (Partija) entity;
        databaseBroker.update(partija);
        partija = (Partija) databaseBroker.select(partija);
        Runda runda = new Runda();
        runda.setPartija(partija);
        List<Runda> runde = (List<Runda>) (ArrayList<?>)databaseBroker.selectMany(runda);
        partija.setRunde(runde);
    }
    
    public Partija vratiPartiju() {
        return partija;
    }
    
}
