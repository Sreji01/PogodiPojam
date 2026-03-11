/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import DomenskiObjekat.GenerickiDomObj;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import SO.KreirajPartiju;
import SO.PrijaviKorisnika;
import SO.SystemOperation;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    Partija kreirajPartiju(Partija partija) throws Exception {
        SystemOperation so = new KreirajPartiju();
        so.templateExecute(partija);
        return ((KreirajPartiju) so).vratiPartiju();
    }
}
