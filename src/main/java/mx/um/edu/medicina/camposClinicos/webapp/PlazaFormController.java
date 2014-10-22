/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.camposClinicos.webapp;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.um.edu.medicina.camposClinicos.model.Plaza;
import mx.um.edu.medicina.service.GenericManager;
import mx.um.edu.medicina.webapp.controller.BaseFormController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author develop
 */
@Controller
@RequestMapping("/camposClinicos/plazaform*")
public class PlazaFormController extends BaseFormController {

    private GenericManager<Plaza, Long> plazaManager = null;

    @Autowired
    public void setPlazaManager(@Qualifier("plazaManager") GenericManager<Plaza, Long> plazaManager) {
        this.plazaManager = plazaManager;
    }
    @Autowired(required = false)
    Validator validator;

    public PlazaFormController() {
        setCancelView("redirect:/camposClinicos/plazas");
        setSuccessView("redirect:/camposClinicos/plazas");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Plaza showForm(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return plazaManager.get(new Long(id));
        }

        return new Plaza();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Plaza plaza, BindingResult errors, HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(plaza, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "plazaform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (plaza.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            plazaManager.remove(plaza.getId());
            saveMessage(request, getText("plaza.deleted", locale));
        } else {
            plazaManager.save(plaza);
            String key = (isNew) ? "plaza.added" : "plaza.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:camposClinicos/plazaform?id=" + plaza.getId();
            }
        }

        return success;
    }
}
