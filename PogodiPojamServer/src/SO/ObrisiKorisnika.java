/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import DomenskiObjekat.Rezultat;
import DomenskiObjekat.Runda;

/**
 *
 * @author Sreja
 */
public class ObrisiKorisnika extends SystemOperation {

    @Override
    protected void validate(Object entity) throws Exception {
    }

    @Override
    protected void execute(Object entity) throws Exception {
        Korisnik korisnik = (Korisnik) entity;
        Rezultat rezultat = new Rezultat();
        Partija partija = new Partija();
        partija.setKorisnik(korisnik);
        rezultat.setPartija(partija);
        Runda runda = new Runda();
        runda.setPartija(partija);
        databaseBroker.delete(rezultat);
        databaseBroker.delete(runda);
        databaseBroker.delete(partija);
        databaseBroker.delete(korisnik);
    }

}
