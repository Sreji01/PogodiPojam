/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import TransferObjekat.ServerResponse;
import java.io.IOException;
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
        ss = new ServerSocket(8189);
        System.out.println("Server je pokrenut!");
        while (true) {
            Socket soketS = ss.accept();
            Klijent kl = new Klijent(soketS, ++brojKlijenta, this);
            lkl.add(kl);
        }
    }

    public void broadcast(ServerResponse so) {
        for (Klijent k : lkl) {
            if (k != null) {
                try {
                    k.posaljiOdgovor(so);
                } catch (IOException ex) {
                    Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
