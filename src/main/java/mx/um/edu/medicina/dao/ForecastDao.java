/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.dao;

import java.util.List;
import mx.um.edu.medicina.model.Forecast;

/**
 *
 * @author develop
 */
public interface ForecastDao extends GenericDao<Forecast, Long> {

    /**
     * Gets a list of plazas ordered by the uppercase version of their
     * plazaname.
     *
     * @return List populated list of plazas
     */
    List<Forecast> getPlazas();

    /**
     * Saves a plaza's information.
     *
     * @param forecast the object to be saved
     * @return the persisted Forecast object
     */
    Forecast savePlaza(Forecast forecast);
}
