/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Sreja
 */
public interface GenerickiDomObj extends Serializable{
    public String getTableName();
    public List<GenerickiDomObj> getList(ResultSet resultSet) throws Exception;
    public GenerickiDomObj getResult(ResultSet resultSet) throws Exception;
    public String getAttributeNames();
    public String getUnknownValues();
    public void prepareStatement(PreparedStatement ps, GenerickiDomObj entity) throws Exception;
    public String getUpdateQuery();
    public String getID(GenerickiDomObj entity);
    public String getCondition(GenerickiDomObj entity);
    public String getOrderCondition();
}
