/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.camposClinicos.dao.hibernate;

import java.util.List;
import mx.um.edu.medicina.camposClinicos.dao.PlazaDao;
import mx.um.edu.medicina.camposClinicos.model.Plaza;
import mx.um.edu.medicina.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Query;

/**
 *
 * @author develop
 */
public class PlazaDaoHibernate extends GenericDaoHibernate<Plaza, Long> implements PlazaDao {

    /**
     * Constructor that sets the entity to Plaza.class.
     */
    public PlazaDaoHibernate() {
        super(Plaza.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Plaza> getPlazas() {
        Query qry = getSession().createQuery("from Plaza p order by upper(p.nombre)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public Plaza savePlaza(Plaza plaza) {
        if (log.isDebugEnabled()) {
            log.debug("plaza's id: " + plaza.getId());
        }
        getSession().saveOrUpdate(plaza);
        // necessary to throw a DataIntegrityViolation and catch it in PlazaManager
        getSession().flush();
        return plaza;
    }

    /**
     * Overridden simply to call the savePlaza method. This is happening because
     * savePlaza flushes the session and saveObject of BaseDaoHibernate does
     * not.
     *
     * @param plaza the plaza to save
     * @return the modified plaza (with a primary key set if they're new)
     */
    @Override
    public Plaza save(Plaza plaza) {
        return this.savePlaza(plaza);
    }
}
