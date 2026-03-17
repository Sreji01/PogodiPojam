/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Partija;
import DomenskiObjekat.Rezultat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sreja
 */
public class ZavrsiPartiju extends SystemOperation {

    @Override
    protected void validate(Object entity) throws Exception {
    }

    @Override
    protected void execute(Object entity) throws Exception {
        Partija partija = (Partija) entity;
        Rezultat rezultat = partija.getRezultat();
        PreparedStatement ps = databaseBroker.insert(rezultat);
        ResultSet resultSet = ps.getGeneratedKeys();
        resultSet.next();
        long idRezultat = resultSet.getLong(1);
        rezultat.setIdRezultat(idRezultat);
        databaseBroker.update(partija);
    }

}
