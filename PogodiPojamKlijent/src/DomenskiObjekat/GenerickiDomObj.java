/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sreja
 */
public interface GenerickiDomObj extends Serializable{
    public String getTableName();
    public String getColumnsForInsert();
    public String getParamsForInsert();
    public String setAtrValue();
    public String getPrimaryKey();
    public String alijas();
    public String join();
    public String getWhereCondition();
    public GenerickiDomObj getNewRecord(ResultSet rs) throws SQLException;
}
