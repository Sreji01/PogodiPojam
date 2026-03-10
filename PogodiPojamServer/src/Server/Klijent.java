package Server;

import DomenskiObjekat.GenerickiDomObj;
import DomenskiObjekat.Korisnik;
import TransferObjekat.ClientRequest;
import TransferObjekat.Operations;
import TransferObjekat.ServerResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Klijent extends Thread {

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

    private ServerResponse obradiZahtev(ClientRequest kz) throws Exception {
        int operacija = kz.getOperation();
        ServerResponse response = new ServerResponse();

        switch (operacija) {
            case Operations.PRIJAVI_KORISNIKA:
                Korisnik korisnik = (Korisnik) kz.getData();
                try {
                    GenerickiDomObj odo = KontrolerServer.getInstance().prijaviKorisnika(korisnik);
                    if (odo != null) {
                        Korisnik kor = (Korisnik) odo;
                        boolean exists = false;
                        for (Klijent kn : server.lkl) {
                            if (kn.getKorisnik() != null && kn.getKorisnik().equals(kor)) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            this.k = kor;
                            response.setIsSuccess(true);
                            response.setParameter(odo);
                        } else {
                            response.setIsSuccess(false);
                            response.setE(new Exception("Korisnik je vec ulogovan!"));
                        }
                    } else {
                        response.setIsSuccess(false);
                        response.setE(new Exception("Pogresno korisnicko ime ili sifra!"));
                    }
                } catch (Exception ex) {
                    response.setIsSuccess(false);
                    response.setE(ex);
                }
                response.setOperation(Operations.PRIJAVI_KORISNIKA);
                break;
            default:
                break;
        }

        return response;
    }

    void posaljiOdgovor(ServerResponse so) throws IOException {
        out.writeObject(so);
    }

    public Korisnik getKorisnik() {
        return k;
    }

    public void setKorisnik(Korisnik k) {
        this.k = k;
    }
}