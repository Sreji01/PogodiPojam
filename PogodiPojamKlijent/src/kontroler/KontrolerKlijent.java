/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import DomenskiObjekat.Korisnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import TransferObjekat.ClientRequest;
import TransferObjekat.Operations;
import TransferObjekat.ServerResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 *
 * @author Sreja
 */
public class KontrolerKlijent {

    private static KontrolerKlijent instance;

    private Korisnik ulogovaniKor;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    private Thread listenerThread;

    private CompletableFuture<ServerResponse> pendingResponse;

    private KontrolerKlijent() {
    }

    public static KontrolerKlijent getInstance() throws IOException {
        if (instance == null) {
            instance = new KontrolerKlijent();
            Socket socket = new Socket("127.0.0.1", 9000);
            instance.initStreams(socket);
        }
        return instance;
    }

    public void initStreams(Socket s) throws IOException {
        this.socket = s;
        out = new ObjectOutputStream(s.getOutputStream());
        in = new ObjectInputStream(s.getInputStream());
        startListener();
    }

    private void startListener() {
        listenerThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Object obj = in.readObject();
                    if (obj instanceof ServerResponse) {
                        ServerResponse so = (ServerResponse) obj;

                        if (pendingResponse != null) {
                            pendingResponse.complete(so);
                            pendingResponse = null;
                        } else {
                            handleAsyncResponse(so);
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Prekinuta konekcija sa serverom.");
            }
        });
        listenerThread.start();
    }

    private Consumer<ServerResponse> asyncListener;

    public void setAsyncListener(Consumer<ServerResponse> listener) {
        this.asyncListener = listener;
    }

    private void handleAsyncResponse(ServerResponse so) {

        if (asyncListener != null) {
            asyncListener.accept(so);
        }

        switch (so.getOperation()) {
            default:

        }
    }

    private ServerResponse sendRequest(ClientRequest req) throws Exception {
        pendingResponse = new CompletableFuture<>();
        out.writeObject(req);
        out.flush();
        return pendingResponse.get();
    }

    public Korisnik prijaviKorisnika(String korisnickoIme, String sifra) throws Exception {
        ClientRequest req = new ClientRequest();
        req.setOperation(Operations.PRIJAVI_KORISNIKA);
        req.setData(new Korisnik(korisnickoIme, sifra));

        ServerResponse so = sendRequest(req);
        if (so.isIsSuccess()) {
            ulogovaniKor = (Korisnik) so.getParameter();
            return ulogovaniKor;
        } else {
            throw so.getE();
        }
    }

}
