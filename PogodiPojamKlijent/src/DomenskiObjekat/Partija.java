/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Partija implements GenerickiDomObj, Serializable{
    
    Long idPartija;
    LocalDateTime vremePocetka;
    LocalDateTime vremeZavrsetka;
    Korisnik korisnik;
    Rezultat rezultat;

    public Partija() {
    }

    public Partija(Long idPartija, LocalDateTime vremePocetka, LocalDateTime vremeZavrsetka, Korisnik korisnik, Rezultat rezultat) {
        this.idPartija = idPartija;
        this.vremePocetka = vremePocetka;
        this.vremeZavrsetka = vremeZavrsetka;
        this.korisnik = korisnik;
        this.rezultat = rezultat;
    }

    public Long getIdPartija() {
        return idPartija;
    }

    public void setIdPartija(Long idPartija) {
        this.idPartija = idPartija;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String getColumnsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
