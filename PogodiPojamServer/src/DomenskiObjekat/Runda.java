/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Runda implements GenerickiDomObj, Serializable {

    Partija partija;
    Long idRunda;
    String tacanOdgovor;
    int brojPokusaja;
    boolean pogodjeno;
    Pojam pojam;

    public Runda() {
    }

    public Runda(Partija partija, Long idRunda, String tacanOdgovor, int brojPokusaja, boolean pogodjeno, Pojam pojam) {
        this.partija = partija;
        this.idRunda = idRunda;
        this.tacanOdgovor = tacanOdgovor;
        this.brojPokusaja = brojPokusaja;
        this.pogodjeno = pogodjeno;
        this.pojam = pojam;
    }

    public Partija getPartija() {
        return partija;
    }

    public void setPartija(Partija partija) {
        this.partija = partija;
    }

    public Long getIdRunda() {
        return idRunda;
    }

    public void setIdRunda(Long idRunda) {
        this.idRunda = idRunda;
    }

    public String getTacanOdgovor() {
        return tacanOdgovor;
    }

    public void setTacanOdgovor(String tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public int getBrojPokusaja() {
        return brojPokusaja;
    }

    public void setBrojPokusaja(int brojPokusaja) {
        this.brojPokusaja = brojPokusaja;
    }

    public boolean isPogodjeno() {
        return pogodjeno;
    }

    public void setPogodjeno(boolean pogodjeno) {
        this.pogodjeno = pogodjeno;
    }

    public Pojam getPojam() {
        return pojam;
    }

    public void setPojam(Pojam pojam) {
        this.pojam = pojam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Runda other = (Runda) obj;
        if (!Objects.equals(this.partija, other.partija)) {
            return false;
        }
        return Objects.equals(this.idRunda, other.idRunda);
    }

    @Override
    public String toString() {
        return "Runda{" + "partija=" + partija + ", idRunda=" + idRunda + ", tacanOdgovor=" + tacanOdgovor + ", brojPokusaja=" + brojPokusaja + ", pogodjeno=" + pogodjeno + ", pojam=" + pojam + '}';
    }

    @Override
    public String getTableName() {
        return "runda";
    }

    @Override
    public String getColumnsForInsert() {
        return "id_partija, tacan_odgovor, id_pojam";
    }

    @Override
    public String getParamsForInsert() {
        return partija.getIdPartija() + ", '" + tacanOdgovor + "', " + pojam.getIdPojam();
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
        return "join partija pa on r.id_partija = pa.id_partija join korisnik k on pa.id_korisnik = k.id_korisnik JOIN pojam p on r.id_pojam = p.id_pojam";
    }

    @Override
    public String getWhereCondition() {
        return "";
    }

    @Override
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException {
        byte[] slika = null;
        java.sql.Blob blob = rs.getBlob("p.slika");
        if (blob != null) {
            slika = blob.getBytes(1, (int) blob.length());
        }
        LocalDateTime pocetak = rs.getTimestamp("pa.vreme_pocetka") != null
                ? rs.getTimestamp("pa.vreme_pocetka").toLocalDateTime()
                : null;
        LocalDateTime kraj = rs.getTimestamp("pa.vreme_zavrsetka") != null
                ? rs.getTimestamp("pa.vreme_zavrsetka").toLocalDateTime()
                : null;
        return new Runda(new Partija(rs.getLong("pa.id_korisnik"), rs.getString("pa.naziv_partije"), pocetak, kraj, rs.getString("pa.odabrana_kategorija"), rs.getInt("pa.broj_rundi"), rs.getString("pa.status"),
                new Korisnik(rs.getLong("k.id_korisnik"), rs.getString("k.ime"), rs.getString("k.prezime"), rs.getString("k.korisnicko_ime"), rs.getString("k.sifra")), null), rs.getLong("r.id_runda"), rs.getString("r.tacan_odgovor"), rs.getInt("r.broj_pokusaja"), rs.getBoolean("r.pogodjeno"), new Pojam(rs.getLong("p.id_pojam"), rs.getString("p.kategorija"), rs.getString("p.naziv"), slika));
    }

}
