/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Partija;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sreja
 */
public class UcitajPartije extends SystemOperation {

    List<Partija> partije;

    @Override
    protected void validate(Object entity) throws Exception {
    }

    @Override
    protected void execute(Object entity) throws Exception {
        partije = (List<Partija>) (ArrayList<?>) databaseBroker.selectMany((Partija) entity);
    }

    public List<Partija> vratiPartije() {
        return partije;
    }
}
