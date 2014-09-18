/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.camposClinicos.dao;

import java.util.List;
import mx.um.edu.medicina.camposClinicos.model.Plaza;
import mx.um.edu.medicina.dao.GenericDao;

/**
 *
 * @author develop
 */
public interface PlazaDao extends GenericDao<Plaza, Long> {
/**
     * Gets a list of plazas ordered by the uppercase version of their plazaname.
     *
     * @return List populated list of plazas
     */
    List<Plaza> getPlazas();

    /**
     * Saves a plaza's information.
     * @param plaza the object to be saved
     * @return the persisted Plaza object
     */
    Plaza savePlaza(Plaza plaza);
}
