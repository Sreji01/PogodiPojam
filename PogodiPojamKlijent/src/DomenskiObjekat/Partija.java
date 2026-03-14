/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
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
        return "Partija{" + "idPartija=" + idPartija + ", vremePocetka=" + vremePocetka + ", vremeZavrsetka=" + vremeZavrsetka + ", korisnik=" + korisnik + ", rezultat=" + rezultat + '}';
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String alijas() {
        return "pa";
    }

    @Override
    public String join() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
