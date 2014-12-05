package mx.um.edu.medicina.webapp.controller;

import mx.um.edu.medicina.webapp.controller.BaseControllerTestCase;
import mx.um.edu.medicina.model.SolicitudInternado;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolicitudInternadoFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private SolicitudInternadoFormController form;
    private SolicitudInternado solicitudInternado;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/solicitudInternadoform");
        request.addParameter("id", "-1");

        solicitudInternado = form.showForm(request);
        assertNotNull(solicitudInternado);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/solicitudInternadoform");
        request.addParameter("id", "-1");

        solicitudInternado = form.showForm(request);
        assertNotNull(solicitudInternado);

        request = newPost("/solicitudInternadoform");

        solicitudInternado = form.showForm(request);
        // update required fields
        solicitudInternado.setApMaterno("WvOlAhBkZbLgNbKhDaUbWtNbRdHcTfZaQbRaHzAgTsKuKrUeTn");
        solicitudInternado.setApPaterno("FvYkTqInYdJkZeXpDyPhGxRuJaIuGbHaCkNoRzCgCmQfSgMvUm");
        solicitudInternado.setMatricula("NjVqOqS");
        solicitudInternado.setNombre("WgSfEmXlIuPlFjVgDgWjNyPjGwNrMpGtHdRfMiRaGsBdMqMiXk");

        BindingResult errors = new DataBinder(solicitudInternado).getBindingResult();
        form.onSubmit(solicitudInternado, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/solicitudInternadoform");
        request.addParameter("delete", "");
        solicitudInternado = new SolicitudInternado();
        solicitudInternado.setId(-2L);

        BindingResult errors = new DataBinder(solicitudInternado).getBindingResult();
        form.onSubmit(solicitudInternado, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
