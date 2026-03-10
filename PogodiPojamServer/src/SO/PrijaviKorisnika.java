/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Korisnik;

/**
 *
 * @author Sreja
 */
public class PrijaviKorisnika extends SystemOperation {
    
    private Korisnik korisnik;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Korisnik)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        korisnik = (Korisnik) databaseBroker.select((Korisnik)entity);
    }

    public Korisnik vratiKorisnika() {
        return korisnik;
    }

}
