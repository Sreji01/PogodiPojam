/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Partija;

/**
 *
 * @author Sreja
 */
public class UcitajPartiju extends SystemOperation{
    Partija partija;

    @Override
    protected void validate(Object entity) throws Exception {
    }

    @Override
    protected void execute(Object entity) throws Exception {
        partija = (Partija) databaseBroker.select((Partija) entity);
    }
    
    public Partija vratiPartiju(){
        return partija;
    }
}
