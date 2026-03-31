package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Partija implements GenerickiDomObj, Serializable {

    private static final long serialVersionUID = 1L;
    Long idPartija;
    String nazivPartije;
    LocalDateTime vremePocetka;
    LocalDateTime vremeZavrsetka;
    String odabranaKategorija;
    int brojRundi;
    String status;
    Korisnik korisnik;
    Rezultat rezultat;
    List<Runda> runde;

    public Partija() {
    }

    public Partija(Long idPartija, String nazivPartije, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka, String odabranaKategorija, int brojRundi, String status, Korisnik korisnik, Rezultat rezultat) {
        this.idPartija = idPartija;
        this.nazivPartije = nazivPartije;
        this.vremePocetka = vremePocetka;
        this.vremeZavrsetka = vremeZavrsetka;
        this.odabranaKategorija = odabranaKategorija;
        this.brojRundi = brojRundi;
        this.status = status;
        this.korisnik = korisnik;
        this.rezultat = rezultat;
    }

    public Partija(Long idPartija, String nazivPartije, String odabranaKategorija, int brojRundi, String status) {
        this.idPartija = idPartija;
        this.nazivPartije = nazivPartije;
        this.odabranaKategorija = odabranaKategorija;
        this.brojRundi = brojRundi;
        this.status = status;
    }

    public Long getIdPartija() {
        return idPartija;
    }

    public void setIdPartija(Long idPartija) {
        this.idPartija = idPartija;
    }

    public String getNazivPartije() {
        return nazivPartije;
    }

    public void setNazivPartije(String nazivPartije) {
        this.nazivPartije = nazivPartije;
    }

    public LocalDateTime getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(LocalDateTime vremePocetka) {
        this.vremePocetka = vremePocetka;
    }

    public LocalDateTime getVremeZavrsetka() {
        return vremeZavrsetka;
    }

    public void setVremeZavrsetka(LocalDateTime vremeZavrsetka) {
        this.vremeZavrsetka = vremeZavrsetka;
    }

    public String getOdabranaKategorija() {
        return odabranaKategorija;
    }

    public void setOdabranaKategorija(String odabranaKategorija) {
        this.odabranaKategorija = odabranaKategorija;
    }

    public int getBrojRundi() {
        return brojRundi;
    }

    public void setBrojRundi(int brojRundi) {
        this.brojRundi = brojRundi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Rezultat getRezultat() {
        return rezultat;
    }

    public void setRezultat(Rezultat rezultat) {
        this.rezultat = rezultat;
    }

    public List<Runda> getRunde() {
        return runde;
    }

    public void setRunde(List<Runda> runde) {
        this.runde = runde;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partija other = (Partija) obj;
        return Objects.equals(this.idPartija, other.idPartija);
    }

    @Override
    public String toString() {
        return "Partija{" + "idPartija=" + idPartija + ", nazivPartije=" + nazivPartije + ", vremePocetka=" + vremePocetka + ", vremeZavrsetka=" + vremeZavrsetka + ", odabranaKategorija=" + odabranaKategorija + ", brojRundi=" + brojRundi + ", status=" + status + '}';
    }

    @Override
    public String getTableName() {
        return "partija";
    }

    @Override
    public String getColumnsForInsert() {
        return "naziv_partije, broj_rundi, odabrana_kategorija, status, id_korisnik";
    }

    @Override
    public String getParamsForInsert() {
        return "'" + nazivPartije + "', " + brojRundi + ", '" + odabranaKategorija + "', " + "'" + status + "', " + korisnik.idKorisnik;
    }

    @Override
    public String setAtrValue() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (vremeZavrsetka == null) {
            return "vreme_pocetka = '" + LocalDateTime.now().format(formatter) + "'";
        }
        return "vreme_zavrsetka = '" + LocalDateTime.now().format(formatter) + "', status = '" + status + "'";
    }

    @Override
    public String getPrimaryKey() {
        return "pa.id_partija = " + idPartija;
    }

    @Override
    public String alijas() {
        return "pa";
    }

    @Override
    public String join() {
        if (status != null) {
            return "JOIN korisnik k ON pa.id_korisnik = k.id_korisnik";
        }
        return "";
    }

    @Override
    public String getWhereCondition() {
        return "WHERE id_korisnik = " + korisnik.getIdKorisnik();
    }

    @Override
    public String getOrderCondition() {
        return "ORDER BY STATUS DESC";
    }

    @Override
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException {
        if (odabranaKategorija != null && brojRundi != 0 && status != null) {
            LocalDateTime pocetak = rs.getTimestamp("pa.vreme_pocetka") != null
                    ? rs.getTimestamp("pa.vreme_pocetka").toLocalDateTime()
                    : null;
            LocalDateTime kraj = rs.getTimestamp("pa.vreme_zavrsetka") != null
                    ? rs.getTimestamp("pa.vreme_zavrsetka").toLocalDateTime()
                    : null;
            if (status.equals("Zavrsena")) {
                return new Partija(
                        rs.getLong("pa.id_partija"),
                        rs.getString("pa.naziv_partije"),
                        pocetak, kraj,
                        rs.getString("pa.odabrana_kategorija"),
                        rs.getInt("pa.broj_rundi"),
                        rs.getString("pa.status"),
                        new Korisnik(rs.getLong("k.id_korisnik"), rs.getString("k.ime"),
                                rs.getString("k.prezime"), rs.getString("k.korisnicko_ime"),
                                rs.getString("k.sifra")), null);
            }
            return new Partija(
                    rs.getLong("pa.id_partija"),
                    rs.getString("pa.naziv_partije"),
                    pocetak, kraj,
                    rs.getString("pa.odabrana_kategorija"),
                    rs.getInt("pa.broj_rundi"),
                    rs.getString("pa.status"),
                    new Korisnik(rs.getLong("k.id_korisnik"), rs.getString("k.ime"),
                            rs.getString("k.prezime"), rs.getString("k.korisnicko_ime"),
                            rs.getString("k.sifra")), null);
        }
        return new Partija(
                rs.getLong("id_partija"),
                rs.getString("naziv_partije"),
                rs.getString("odabrana_kategorija"),
                rs.getInt("broj_rundi"),
                rs.getString("status"));
    }

    @Override
    public String getDeleteCondition() {
        return "id_korisnik = " + korisnik.getIdKorisnik();
    }
}
