/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.camposClinicos.service.impl;

import java.util.List;
import mx.um.edu.medicina.camposClinicos.dao.PlazaDao;
import mx.um.edu.medicina.camposClinicos.service.PlazaManager;
import mx.um.edu.medicina.camposClinicos.model.Plaza;
import mx.um.edu.medicina.service.impl.GenericManagerImpl;
import mx.um.edu.medicina.util.exception.PlazaExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author develop
 */
@Service
public class PlazaManagerImpl extends GenericManagerImpl<Plaza, Long> implements PlazaManager {

    private PlazaDao plazaDao;

    @Override
    @Autowired
    public void setPlazaDao(final PlazaDao plazaDao) {
        this.dao = plazaDao;
        this.plazaDao = plazaDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Plaza getPlaza(final String plazaId) {
        return plazaDao.get(new Long(plazaId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Plaza> getPlazas() {
        return plazaDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Plaza savePlaza(final Plaza plaza) throws PlazaExistException {

        if (plaza.getVersion() == null) {
            // if new plaza, lowercase plazaId
            plaza.setNombre(plaza.getNombre().toLowerCase());
        }

        try {
            return plazaDao.savePlaza(plaza);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new PlazaExistException("Plaza '" + plaza.getNombre() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePlaza(final Plaza plaza) {
        log.debug("removing plaza: " + plaza);
        plazaDao.remove(plaza);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePlaza(final String plazaId) {
        log.debug("removing plaza: " + plazaId);
        plazaDao.remove(new Long(plazaId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Plaza> search(final String searchTerm) {
        return super.search(searchTerm, Plaza.class);
    }
}
