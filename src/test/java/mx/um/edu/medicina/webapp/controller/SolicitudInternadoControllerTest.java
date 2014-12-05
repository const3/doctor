package mx.um.edu.medicina.webapp.controller;

import mx.um.edu.medicina.service.GenericManager;
import mx.um.edu.medicina.model.SolicitudInternado;

import mx.um.edu.medicina.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolicitudInternadoControllerTest extends BaseControllerTestCase {
    @Autowired
    private SolicitudInternadoController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("solicitudInternadoList"));
        assertTrue(((List) m.get("solicitudInternadoList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        GenericManager<SolicitudInternado, Long> solicitudInternadoManager = (GenericManager<SolicitudInternado, Long>) applicationContext.getBean("solicitudInternadoManager");
        solicitudInternadoManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("solicitudInternadoList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}