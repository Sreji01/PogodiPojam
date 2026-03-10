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
public class Pokusaj implements GenerickiDomObj, Serializable{
    
    Long idPokusaj;
    private String unesenPojam;
    private boolean tacno;
    private Runda runda;

    public Pokusaj() {
    }

    public Pokusaj(Long idPokusaj, String unesenPojam, boolean tacno, Runda runda) {
        this.idPokusaj = idPokusaj;
        this.unesenPojam = unesenPojam;
        this.tacno = tacno;
        this.runda = runda;
    }

    public Long getIdPokusaj() {
        return idPokusaj;
    }

    public void setIdPokusaj(Long idPokusaj) {
        this.idPokusaj = idPokusaj;
    }

    public String getUnesenPojam() {
        return unesenPojam;
    }

    public void setUnesenPojam(String unesenPojam) {
        this.unesenPojam = unesenPojam;
    }

    public boolean isTacno() {
        return tacno;
    }

    public void setTacno(boolean tacno) {
        this.tacno = tacno;
    }

    public Runda getRunda() {
        return runda;
    }

    public void setRunda(Runda runda) {
        this.runda = runda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Pokusaj other = (Pokusaj) obj;
        return Objects.equals(this.idPokusaj, other.idPokusaj);
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
