/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Database;

import DomenskiObjekat.GenerickiDomObj;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sreja
 */
public interface IDBBroker {

    public List<GenerickiDomObj> selectMany(GenerickiDomObj gdo) throws SQLException;
    public GenerickiDomObj select(GenerickiDomObj gdo) throws SQLException;
    public PreparedStatement insert(GenerickiDomObj gdo) throws SQLException;
    public void update(GenerickiDomObj gdo) throws SQLException;
    public void delete(GenerickiDomObj gdo) throws SQLException;
}
