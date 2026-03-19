/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Rezultat implements GenerickiDomObj, Serializable {

    Long idRezultat;
    int ukupanBrojPoena;
    int ukupanBrojPokusaja;
    int ukupnoVreme;
    Partija partija;

    public Rezultat() {
    }

    public Rezultat(Long idRezultat, int ukupanBrojPoena, int ukupanBrojPokusaja, int ukupnoVreme, Partija partija) {
        this.idRezultat = idRezultat;
        this.ukupanBrojPoena = ukupanBrojPoena;
        this.ukupanBrojPokusaja = ukupanBrojPokusaja;
        this.ukupnoVreme = ukupnoVreme;
        this.partija = partija;
    }

    public Long getIdRezultat() {
        return idRezultat;
    }

    public void setIdRezultat(Long idRezultat) {
        this.idRezultat = idRezultat;
    }

    public int getUkupanBrojPoena() {
        return ukupanBrojPoena;
    }

    public void setUkupanBrojPoena(int ukupanBrojPoena) {
        this.ukupanBrojPoena = ukupanBrojPoena;
    }

    public int getUkupanBrojPokusaja() {
        return ukupanBrojPokusaja;
    }

    public void setUkupanBrojPokusaja(int ukupanBrojPokusaja) {
        this.ukupanBrojPokusaja = ukupanBrojPokusaja;
    }

    public int getUkupnoVreme() {
        return ukupnoVreme;
    }

    public void setUkupnoVreme(int ukupnoVreme) {
        this.ukupnoVreme = ukupnoVreme;
    }

    public Partija getPartija() {
        return partija;
    }

    public void setPartija(Partija partija) {
        this.partija = partija;
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
        final Rezultat other = (Rezultat) obj;
        return Objects.equals(this.idRezultat, other.idRezultat);
    }

    @Override
    public String toString() {
        return "Rezultat{" + "idRezultat=" + idRezultat + ", ukupanBrojPoena=" + ukupanBrojPoena + ", ukupanBrojPokusaja=" + ukupanBrojPokusaja + ", ukupnoVreme=" + ukupnoVreme + '}';
    }

    @Override
    public String getTableName() {
        return "rezultat";
    }

    @Override
    public String getColumnsForInsert() {
        return "ukupan_broj_poena, ukupan_broj_pokusaja, ukupno_provedeno_vreme, id_partija";
    }

    @Override
    public String getParamsForInsert() {
        return ukupanBrojPoena + ", " + ukupanBrojPokusaja + ", " + ukupnoVreme + ", " + partija.idPartija;
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String alijas() {
        return "r";
    }

    @Override
    public String join() {
        return "JOIN partija pa ON r.id_partija = pa.id_partija JOIN korisnik k ON pa.id_korisnik = k.id_korisnik";
    }

    @Override
    public String getWhereCondition() {
        if (partija == null) {
            return "";
        }

        List<String> uslovi = new ArrayList<>();
        if (partija.getOdabranaKategorija() != null) {
            uslovi.add("pa.odabrana_kategorija = '" + partija.getOdabranaKategorija() + "'");
        }
        if (partija.getBrojRundi() != 0) {
            uslovi.add("pa.broj_rundi = " + partija.getBrojRundi());
        }

        return uslovi.isEmpty() ? "" : "WHERE " + String.join(" AND ", uslovi);
    }

    @Override
    public String getOrderCondition() {
        return "ORDER BY r.ukupan_broj_poena DESC, r.ukupan_broj_pokusaja ASC, r.ukupno_provedeno_vreme ASC";
    }

    @Override
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException {
        Korisnik k = new Korisnik(
                rs.getLong("k.id_korisnik"),
                rs.getString("k.ime"),
                rs.getString("k.prezime"),
                rs.getString("k.korisnicko_ime"),
                rs.getString("k.sifra")
        );

        LocalDateTime pocetak = rs.getTimestamp("pa.vreme_pocetka") != null
                ? rs.getTimestamp("pa.vreme_pocetka").toLocalDateTime() : null;
        LocalDateTime kraj = rs.getTimestamp("pa.vreme_zavrsetka") != null
                ? rs.getTimestamp("pa.vreme_zavrsetka").toLocalDateTime() : null;

        Partija pa = new Partija(
                rs.getLong("pa.id_partija"),
                rs.getString("pa.naziv_partije"),
                pocetak,
                kraj,
                rs.getString("pa.odabrana_kategorija"),
                rs.getInt("pa.broj_rundi"),
                rs.getString("pa.status"),
                k,
                null
        );

        Rezultat rez = new Rezultat(
                rs.getLong("r.id_rezultat"),
                rs.getInt("r.ukupan_broj_poena"),
                rs.getInt("r.ukupan_broj_pokusaja"),
                rs.getInt("r.ukupno_provedeno_vreme"),
                pa
        );

        pa.setRezultat(rez);

        return rez;
    }

    @Override
    public String getDeleteCondition() {
        return "id_partija IN (SELECT id_partija FROM partija WHERE id_korisnik = "
                + partija.getKorisnik().getIdKorisnik() + ")";
    }
}
