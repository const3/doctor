package mx.um.edu.medicina.webapp.controller;

import mx.um.edu.medicina.Constants;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import mx.um.edu.medicina.service.UserManager;

import static org.junit.Assert.*;

public class UserControllerTest extends BaseControllerTestCase {
    @Autowired
    private UserController c;

    @Test
    public void testHandleRequest() throws Exception {
        ModelAndView mav = c.handleRequest(null);
        Map m = mav.getModel();
        assertNotNull(m.get(Constants.USER_LIST));
        assertEquals("admin/userList", mav.getViewName());
    }

    @Test
    public void testSearch() throws Exception {
        // reindex before searching
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.reindex();

        ModelAndView mav = c.handleRequest("admin");
        Map m = mav.getModel();
        List results = (List) m.get(Constants.USER_LIST);
        assertNotNull(results);
        assertTrue(results.size() >= 1);
        assertEquals("admin/userList", mav.getViewName());
    }
}