/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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

    public Rezultat() {
    }

    public Rezultat(Long idRezultat, int ukupanBrojPoena, int ukupanBrojPokusaja, int ukupnoVreme) {
        this.idRezultat = idRezultat;
        this.ukupanBrojPoena = ukupanBrojPoena;
        this.ukupanBrojPokusaja = ukupanBrojPokusaja;
        this.ukupnoVreme = ukupnoVreme;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenerickiDomObj> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenerickiDomObj getResult(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAttributeNames() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUnknownValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenerickiDomObj entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID(GenerickiDomObj entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCondition(GenerickiDomObj entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getOrderCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
