/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.webapp.controller;

import mx.um.edu.medicina.camposClinicos.service.PlazaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author develop
 */
@Controller
@RequestMapping("/plazas*")
public class PlazaController {

    private PlazaManager plazaManager = null;

    @Autowired
    public void setPlazaManager(PlazaManager plazaManager) {
        this.plazaManager = plazaManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
            throws Exception {
        return new ModelAndView().addObject(plazaManager.getAll());
    }
}
