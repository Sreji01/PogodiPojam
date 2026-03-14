/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import DomenskiObjekat.GenerickiDomObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sreja
 */
public class DatabaseBroker implements IDBBroker{
    
    @Override
    public List<GenerickiDomObj> selectMany(GenerickiDomObj gdo) throws SQLException {
        List<GenerickiDomObj> ls = new ArrayList<>();
        String upit = "SELECT * FROM " + gdo.getTableName() + " " + gdo.alijas() + " " + gdo.join() + " " + gdo.getWhereCondition();
        System.out.println(upit);
        Statement s = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            ls.add(gdo.getNewRecord(rs));
        }
        return ls;
    }
    
    @Override
    public GenerickiDomObj select(GenerickiDomObj gdo) throws SQLException {
        String upit = "SELECT * FROM " + gdo.getTableName() + " " + gdo.alijas() + " " + gdo.join() + " WHERE " + gdo.getPrimaryKey();
        System.out.println(upit);
        Statement s = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            gdo = gdo.getNewRecord(rs);
        }
        return gdo;
    }

    @Override
    public PreparedStatement insert(GenerickiDomObj gdo) throws SQLException {
        String upit = "INSERT INTO " + gdo.getTableName() + " (" + gdo.getColumnsForInsert() + ") VALUES (" + gdo.getParamsForInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }
    
    @Override
    public void update(GenerickiDomObj gdo) throws SQLException {
        String upit = "UPDATE " + gdo.getTableName() + " SET " + gdo.setAtrValue() + " WHERE " + gdo.getPrimaryKey();
        System.out.println(upit);
        PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(upit);
        ps.executeUpdate();
    }

    @Override
    public void delete(GenerickiDomObj gdo) throws SQLException{
        String upit = "DELETE FROM " +gdo.getTableName() + " WHERE " +gdo.getPrimaryKey();
        System.out.println(upit);
        Statement s = DatabaseConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(upit);
    }
}
