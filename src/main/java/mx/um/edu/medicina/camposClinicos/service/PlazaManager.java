/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.camposClinicos.service;

import java.util.List;
import mx.um.edu.medicina.camposClinicos.dao.PlazaDao;
import mx.um.edu.medicina.camposClinicos.model.Plaza;
import mx.um.edu.medicina.service.GenericManager;
import mx.um.edu.medicina.util.exception.PlazaExistException;

/**
 *
 * @author develop
 */
public interface PlazaManager extends GenericManager<Plaza, Long> {

    /**
     * Convenience method for testing - allows you to mock the DAO and set it on
     * an interface.
     *
     * @param plazaDao the PlazaDao implementation to use
     */
    void setPlazaDao(PlazaDao plazaDao);

    /**
     * Retrieves a plaza by plazaId. An exception is thrown if plaza not found
     *
     * @param plazaId the identifier for the plaza
     * @return Plaza
     */
    Plaza getPlaza(String plazaId);

    /**
     * Retrieves a list of all plazas.
     *
     * @return List
     */
    List<Plaza> getPlazas();

    /**
     * Saves a plaza's information.
     *
     * @param plaza the plaza's information
     * @return plaza the updated plaza object
     * @throws mx.um.edu.medicina.util.exception.PlazaExistException
     */
    Plaza savePlaza(Plaza plaza) throws PlazaExistException;

    /**
     * Removes a plaza from the database
     *
     * @param plaza the plaza to remove
     */
    void removePlaza(Plaza plaza);

    /**
     * Removes a plaza from the database by their plazaId
     *
     * @param plazaId the plaza's id
     */
    void removePlaza(String plazaId);

    /**
     * Search a plaza for search terms.
     *
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Plaza> search(String searchTerm);

}
