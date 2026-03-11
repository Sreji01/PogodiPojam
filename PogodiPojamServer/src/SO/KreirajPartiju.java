/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Partija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sreja
 */
public class KreirajPartiju extends SystemOperation {

    Partija partija;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Partija)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        PreparedStatement ps = databaseBroker.insert((Partija) entity);
        ResultSet resultSet = ps.getGeneratedKeys();
        resultSet.next();
        long idPartija = resultSet.getLong(1);
        partija = new Partija();
        partija.setIdPartija(idPartija);
    }

    public Partija vratiPartiju() {
        return partija;
    }

}
