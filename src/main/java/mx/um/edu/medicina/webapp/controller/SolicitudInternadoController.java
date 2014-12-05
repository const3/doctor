package mx.um.edu.medicina.webapp.controller;

import mx.um.edu.medicina.dao.SearchException;
import mx.um.edu.medicina.service.GenericManager;
import mx.um.edu.medicina.model.SolicitudInternado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/solicitudInternadoes*")
public class SolicitudInternadoController {
    private GenericManager<SolicitudInternado, Long> solicitudInternadoManager;

    @Autowired
    public void setSolicitudInternadoManager(@Qualifier("solicitudInternadoManager") GenericManager<SolicitudInternado, Long> solicitudInternadoManager) {
        this.solicitudInternadoManager = solicitudInternadoManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(solicitudInternadoManager.search(query, SolicitudInternado.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(solicitudInternadoManager.getAll());
        }
        return model;
    }
}
