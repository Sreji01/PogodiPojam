/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package Server;

import DomenskiObjekat.Korisnik;
import SO.RegistrujKorisnika;
import SO.SystemOperation;
import javax.jws.WebService;

/**
 *
 * @author Sreja
 */
@WebService(serviceName = "GenerickiKontrolerServer")
public class GenerickiKontrolerServer {

    public void registrujKorisnika(String ime, String prezime, String korisnickoIme, String sifra) throws Exception {

        Korisnik kor = new Korisnik();
        kor.setIme(ime);
        kor.setPrezime(prezime);
        kor.setKorisnickoIme(korisnickoIme);
        kor.setSifra(sifra);

        SystemOperation so = new RegistrujKorisnika();

        so.templateExecute(kor);
    }
}
