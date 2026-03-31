/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Partija;
import DomenskiObjekat.Pojam;
import DomenskiObjekat.Runda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        partija = (Partija) entity;
        PreparedStatement ps = databaseBroker.insert(partija);
        ResultSet resultSet = ps.getGeneratedKeys();
        resultSet.next();
        long idPartija = resultSet.getLong(1);
        partija.setIdPartija(idPartija);
        Pojam pojam = new Pojam();
        pojam.setKategorija(partija.getOdabranaKategorija());
        List<Pojam> pojmovi = (List<Pojam>) (ArrayList<?>) databaseBroker.selectMany(pojam);

        if (partija.getBrojRundi() > pojmovi.size()) {
            throw new Exception("Nema dovoljno pojmova za trazeni broj rundi!");
        }

        java.util.Collections.shuffle(pojmovi);

        for (long i = 0; i < partija.getBrojRundi(); i++) {
            Runda runda = new Runda();
            runda.setIdRunda(i + 1);
            runda.setTacanOdgovor(pojmovi.get((int) i).getNaziv());
            runda.setPojam(pojmovi.get((int) i));
            runda.setPartija(partija);
            databaseBroker.insert(runda);
        }
    }

    public Partija vratiPartiju() {
        return partija;
    }

}
