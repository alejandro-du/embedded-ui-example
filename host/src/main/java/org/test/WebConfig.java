package org.test;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author Alejandro Duarte.
 */
public class WebConfig {

    @WebServlet(urlPatterns = "/*", asyncSupported = true)
    @VaadinServletConfiguration(ui = HostUI.class, productionMode = false)
    public static class HostUIServlet extends VaadinServlet {
    }

}
