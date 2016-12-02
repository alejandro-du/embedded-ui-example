package org.test;

import com.thetransactioncompany.cors.CORSFilter;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * @author Alejandro Duarte.
 */
public class WebConfig {

    @WebServlet(urlPatterns = "/*", asyncSupported = true)
    @VaadinServletConfiguration(ui = EmbeddedUI2.class, productionMode = false)
    public static class EmbeddedUI2Servlet extends VaadinServlet {
    }

    @WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "cors.allowOrigin", value = "*"))
    public static class EmbeddedUI2CorsFilter extends CORSFilter {
    }

    @WebListener
    public static class SessionCookieConfigListener implements ServletContextListener {

        @Override
        public void contextInitialized(ServletContextEvent event) {
            event.getServletContext().getSessionCookieConfig().setName("ui2-session-id");
        }

        @Override
        public void contextDestroyed(ServletContextEvent event) {

        }
    }

}
