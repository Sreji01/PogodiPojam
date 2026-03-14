/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Runda implements GenerickiDomObj, Serializable{
    
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
        return "id_partija, id_pojam";
    }

    @Override
    public String getParamsForInsert() {
        return partija.getIdPartija() + ", " + pojam.getIdPojam();
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
