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
public class Rezultat implements GenerickiDomObj, Serializable{
    
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
