package Server;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import DomenskiObjekat.Rezultat;
import TransferObjekat.ClientRequest;
import TransferObjekat.Operations;
import TransferObjekat.ServerResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    korisnik = KontrolerServer.getInstance().prijaviKorisnika(korisnik);
                    if (korisnik != null) {
                        boolean exists = false;
                        for (Klijent kn : server.lkl) {
                            if (kn.getKorisnik() != null && kn.getKorisnik().equals(korisnik)) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            response.setIsSuccess(true);
                            response.setParameter(korisnik);
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
            case Operations.UCITAJ_PARTIJE:
                Partija partijaZaUcitavanje = (Partija) kz.getData();
                try {
                    List<Partija> partije = KontrolerServer.getInstance().ucitajPartije(partijaZaUcitavanje);
                    response.setIsSuccess(true);
                    response.setParameter(partije);
                    response.setOperation(Operations.UCITAJ_PARTIJE);
                } catch (Exception ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                    response.setIsSuccess(false);
                    response.setOperation(Operations.UCITAJ_PARTIJE);
                    response.setE(ex);
                }
                break;

            case Operations.KREIRAJ_PARTIJU:
                Partija partija = (Partija) kz.getData();
                try {
                    partija = KontrolerServer.getInstance().kreirajPartiju(partija);
                    if (partija != null) {
                        response.setIsSuccess(true);
                        response.setParameter(partija);
                        response.setOperation(Operations.KREIRAJ_PARTIJU);

                    } else {
                        response.setIsSuccess(false);
                        response.setParameter(partija);
                        response.setOperation(Operations.KREIRAJ_PARTIJU);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                    response.setIsSuccess(false);
                    response.setOperation(Operations.KREIRAJ_PARTIJU);
                    response.setE(ex);
                }
                posaljiOdgovor(response);
                break;
            case Operations.ZAPOCNI_PARTIJU:
                Partija partijaZaStart = (Partija) kz.getData();
                try {
                    partijaZaStart = KontrolerServer.getInstance().zapocniPartiju(partijaZaStart);
                    response.setIsSuccess(true);
                    response.setParameter(partijaZaStart);
                    response.setOperation(Operations.ZAPOCNI_PARTIJU);
                } catch (Exception ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                    response.setIsSuccess(false);
                    response.setOperation(Operations.ZAPOCNI_PARTIJU);
                    response.setE(ex);
                }
                break;
            case Operations.ZAVRSI_PARTIJU:
                Partija partijaZaZavrsavanje = (Partija) kz.getData();
                try {
                    KontrolerServer.getInstance().zavrsiPartiju(partijaZaZavrsavanje);
                    response.setIsSuccess(true);
                    response.setOperation(Operations.ZAVRSI_PARTIJU);
                } catch (Exception ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                    response.setIsSuccess(false);
                    response.setOperation(Operations.ZAVRSI_PARTIJU);
                    response.setE(ex);
                }
                break;
            case Operations.UCITAJ_PARTIJU:
                Partija partijaZaDetalje = (Partija) kz.getData();
                try {
                    partijaZaDetalje = KontrolerServer.getInstance().ucitajPartiju(partijaZaDetalje);
                    response.setIsSuccess(true);
                    response.setParameter(partijaZaDetalje);
                    response.setOperation(Operations.UCITAJ_PARTIJU);
                } catch (Exception ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                    response.setIsSuccess(false);
                    response.setOperation(Operations.UCITAJ_PARTIJU);
                    response.setE(ex);
                }
                break;
            case Operations.UCITAJ_REZULTATE:
                try {
                List<Rezultat> rezultati = KontrolerServer.getInstance().ucitajRezultate();
                response.setIsSuccess(true);
                response.setParameter(rezultati);
                response.setOperation(Operations.UCITAJ_REZULTATE);
            } catch (Exception ex) {
                Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                response.setIsSuccess(false);
                response.setOperation(Operations.UCITAJ_REZULTATE);
                response.setE(ex);
            }
            break;
            case Operations.PRETRAZI_REZULTATE:
                Rezultat rezultat = (Rezultat) kz.getData();
                try {
                    List<Rezultat> rezultati = KontrolerServer.getInstance().pretraziRezultate(rezultat);
                    response.setIsSuccess(true);
                    response.setParameter(rezultati);
                    response.setOperation(Operations.PRETRAZI_REZULTATE);
                } catch (Exception ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                    response.setIsSuccess(false);
                    response.setOperation(Operations.PRETRAZI_REZULTATE);
                    response.setE(ex);
                }
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
