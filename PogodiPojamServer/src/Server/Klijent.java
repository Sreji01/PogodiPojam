/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import DomenskiObjekat.Korisnik;
import TransferObjekat.ClientRequest;
import TransferObjekat.ServerResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Sreja
 */
public class Klijent extends Thread{

    private Socket soketS;
    ObjectOutputStream out;
    ObjectInputStream in;
    KontrolerServer server;
    int brojKlijenta;
    Korisnik k;

    public Klijent(Socket soketS1, int brojKlijenta, KontrolerServer ks) {

        soketS = soketS1;
        this.brojKlijenta = brojKlijenta;
        this.server = ks;

        System.out.println("Klijent:" + brojKlijenta + " je povezan!");
        start();

    }

    public void run() {
        try {

            out = new ObjectOutputStream(soketS.getOutputStream());
            in = new ObjectInputStream(soketS.getInputStream());

            while (true) {
                Object object = in.readObject();
                if (object instanceof ClientRequest) {
                    ClientRequest kz = (ClientRequest) object;
                    ServerResponse so = obradiZahtev(kz);
                    posaljiOdgovor(so);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerResponse obradiZahtev(ClientRequest kz) throws IOException {
        int operacija = kz.getOperation();
        ServerResponse response = new ServerResponse();

        switch (operacija) {
            default:
                break;

        }
        System.out.println(response.getOperation());
        return response;
    }

    void posaljiOdgovor(ServerResponse so) throws IOException {
        out.writeObject(so);
    }

    public Korisnik getKorisnik() {
        return k;
    }
}
