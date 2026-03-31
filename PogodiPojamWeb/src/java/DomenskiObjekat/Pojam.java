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
public class Pojam implements GenerickiDomObj, Serializable {

    Long idPojam;
    String kategorija;
    String naziv;
    byte[] slika;

    public Pojam() {
    }

    public Pojam(Long idPojam, String kategorija, String naziv, byte[] slika) {
        this.idPojam = idPojam;
        this.kategorija = kategorija;
        this.naziv = naziv;
        this.slika = slika;
    }

    public Long getIdPojam() {
        return idPojam;
    }

    public void setIdPojam(Long idPojam) {
        this.idPojam = idPojam;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
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
        final Pojam other = (Pojam) obj;
        if (!Objects.equals(this.kategorija, other.kategorija)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return Objects.equals(this.idPojam, other.idPojam);
    }

    @Override
    public String toString() {
        return "Pojam{" + "idPojam=" + idPojam + ", kategorija=" + kategorija + ", naziv=" + naziv + ", slika=" + slika + '}';
    }

    @Override
    public String getTableName() {
        return "pojam";
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
        return "po";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String getWhereCondition() {
        if (kategorija.equals("Sve")) {
            return "";
        } else {
            return "WHERE kategorija = '" + kategorija + "'";
        }
    }
    
    @Override
    public String getOrderCondition() {
        return "ORDER BY RAND()";
    }

    @Override
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException {
        byte[] slikaPojma = null;
        java.sql.Blob blob = rs.getBlob("slika");
        if (blob != null) {
            try {
                java.io.InputStream is = blob.getBinaryStream();
                java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
                byte[] chunk = new byte[4096];
                int b;
                while ((b = is.read(chunk)) != -1) {
                    buffer.write(chunk, 0, b);
                }
                slikaPojma = buffer.toByteArray();
                is.close();
            } catch (java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
        return new Pojam(rs.getLong("id_pojam"), rs.getString("kategorija"), rs.getString("naziv"), slikaPojma);
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
