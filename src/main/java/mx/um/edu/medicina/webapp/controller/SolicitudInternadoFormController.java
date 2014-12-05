package mx.um.edu.medicina.webapp.controller;

import org.apache.commons.lang.StringUtils;
import mx.um.edu.medicina.service.GenericManager;
import mx.um.edu.medicina.model.SolicitudInternado;
import mx.um.edu.medicina.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/solicitudInternadoform*")
public class SolicitudInternadoFormController extends BaseFormController {
    private GenericManager<SolicitudInternado, Long> solicitudInternadoManager = null;

    @Autowired
    public void setSolicitudInternadoManager(@Qualifier("solicitudInternadoManager") GenericManager<SolicitudInternado, Long> solicitudInternadoManager) {
        this.solicitudInternadoManager = solicitudInternadoManager;
    }

    public SolicitudInternadoFormController() {
        setCancelView("redirect:solicitudInternadoes");
        setSuccessView("redirect:solicitudInternadoes");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected SolicitudInternado showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return solicitudInternadoManager.get(new Long(id));
        }

        return new SolicitudInternado();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(SolicitudInternado solicitudInternado, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(solicitudInternado, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "solicitudInternadoform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (solicitudInternado.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            solicitudInternadoManager.remove(solicitudInternado.getId());
            saveMessage(request, getText("solicitudInternado.deleted", locale));
        } else {
            solicitudInternadoManager.save(solicitudInternado);
            String key = (isNew) ? "solicitudInternado.added" : "solicitudInternado.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:solicitudInternadoform?id=" + solicitudInternado.getId();
            }
        }

        return success;
    }
}
