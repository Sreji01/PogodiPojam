/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Korisnik implements GenerickiDomObj, Serializable {

    private static final long serialVersionUID = 1L;
    Long idKorisnik;
    String ime;
    String prezime;
    String korisnickoIme;
    String sifra;

    public Korisnik() {
    }

    public Korisnik(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Korisnik(Long idKorisnik, String ime, String prezime, String korisnickoIme, String sifra) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Long getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Long idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String toString() {
        return "Korisnik{" + "idKorisnik=" + idKorisnik + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", sifra=" + sifra + '}';
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, korisnicko_ime, sifra";
    }

    @Override
    public String getParamsForInsert() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + sifra + "'";
    }

    @Override
    public String setAtrValue() {
        return "sifra = '" + sifra + "'";
    }

    @Override
    public String getPrimaryKey() {
        if (idKorisnik == null) {
            return "korisnicko_ime = '" + korisnickoIme + "' AND sifra = '" + sifra + "'";
        }
        return "id_korisnik = " + idKorisnik;
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getOrderCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException {
        return new Korisnik(rs.getLong("k.id_korisnik"), rs.getString("k.ime"), rs.getString("k.prezime"), rs.getString("k.korisnicko_ime"), rs.getString("k.sifra"));
    }

    @Override
    public String getDeleteCondition() {
        return "id_korisnik = " + idKorisnik;
    }

}
