/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import DomenskiObjekat.Rezultat;
import SO.AzurirajKorisnika;
import SO.KreirajPartiju;
import SO.ObrisiKorisnika;
import SO.PretraziRezultate;
import SO.PrijaviKorisnika;
import SO.SystemOperation;
import SO.UcitajPartije;
import SO.UcitajPartiju;
import SO.UcitajRezultate;
import SO.ZapocniPartiju;
import SO.ZavrsiPartiju;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sreja
 */
public class KontrolerServer {

    static ServerSocket ss;
    static List<Klijent> lkl = new ArrayList<>();
    static int brojKlijenta;
    private static KontrolerServer instance;

    private KontrolerServer() {
    }

    public static KontrolerServer getInstance() {
        if (instance == null) {
            instance = new KontrolerServer();
        }
        return instance;
    }

    public static void main(String arg[]) throws Exception {

        KontrolerServer.getInstance().izvrsiGenerickiKontroler();
    }

    void izvrsiGenerickiKontroler() throws Exception {
        ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut!");
        while (true) {
            Socket soketS = ss.accept();
            Klijent kl = new Klijent(soketS, ++brojKlijenta, this);
            lkl.add(kl);
        }
    }

    Korisnik prijaviKorisnika(Korisnik korisnik) throws Exception {
        SystemOperation so = new PrijaviKorisnika();

        so.templateExecute(korisnik);
        return ((PrijaviKorisnika) so).vratiKorisnika();
    }

    List<Partija> ucitajPartije(Partija partija) throws Exception {
        SystemOperation so = new UcitajPartije();

        so.templateExecute(partija);
        return ((UcitajPartije) so).vratiPartije();
    }

    Partija kreirajPartiju(Partija partija) throws Exception {
        SystemOperation so = new KreirajPartiju();
        so.templateExecute(partija);
        return ((KreirajPartiju) so).vratiPartiju();
    }

    Partija zapocniPartiju(Partija partija) throws Exception {
        SystemOperation so = new ZapocniPartiju();
        so.templateExecute(partija);
        return ((ZapocniPartiju) so).vratiPartiju();
    }

    void zavrsiPartiju(Partija partija) throws Exception {
        SystemOperation so = new ZavrsiPartiju();
        so.templateExecute(partija);
    }

    Partija ucitajPartiju(Partija partija) throws Exception {
        SystemOperation so = new UcitajPartiju();
        so.templateExecute(partija);
        return ((UcitajPartiju) so).vratiPartiju();
    }

    List<Rezultat> ucitajRezultate() throws Exception {
        SystemOperation so = new UcitajRezultate();
        Rezultat rezultat = new Rezultat();
        so.templateExecute(rezultat);
        return ((UcitajRezultate) so).vratiRezultate();
    }

    List<Rezultat> pretraziRezultate(Rezultat rezultat) throws Exception {
        SystemOperation so = new PretraziRezultate();
        so.templateExecute(rezultat);
        return ((PretraziRezultate) so).vratiRezultate();
    }

    void azurirajKorisnika(Korisnik korisnik) throws Exception {
        SystemOperation so = new AzurirajKorisnika();
        so.templateExecute(korisnik);
    }

    void obrisiKorisnika(Korisnik korisnik) throws Exception {
        SystemOperation so = new ObrisiKorisnika();
        so.templateExecute(korisnik);
    }

}
