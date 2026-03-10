/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Database;

import DomenskiObjekat.GenerickiDomObj;
import java.util.List;

/**
 *
 * @author Sreja
 */
public interface IDBBroker {
    List<GenerickiDomObj> selectAll(GenerickiDomObj odo) throws Exception;
    GenerickiDomObj select(GenerickiDomObj odo,Long id) throws Exception;
    Long insert(GenerickiDomObj odo) throws Exception;
    int update(GenerickiDomObj odo) throws Exception;
    void delete(GenerickiDomObj odo) throws Exception;
}
