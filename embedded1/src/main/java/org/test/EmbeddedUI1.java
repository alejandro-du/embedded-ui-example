package org.test;

import com.thetransactioncompany.cors.CORSFilter;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridBasedCrudComponent;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Alejandro Duarte
 */
@Theme(ValoTheme.THEME_NAME)
public class EmbeddedUI1 extends UI implements CrudListener<User> {

    private static Set<User> users = new LinkedHashSet<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        GridBasedCrudComponent<User> crud = new GridBasedCrudComponent<>(User.class);
        crud.setCrudListener(this);

        VerticalLayout layout = new VerticalLayout(crud);
        layout.setSizeFull();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }

    @Override
    public Collection<User> findAll() {
        return users;
    }

    @Override
    public User add(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        return user;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = EmbeddedUI1.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    @WebListener
    public static class SessionCookieConfigListener implements ServletContextListener {

        @Override
        public void contextInitialized(ServletContextEvent event) {
            event.getServletContext().getSessionCookieConfig().setName("ui1-session-id");
        }

        @Override
        public void contextDestroyed(ServletContextEvent event) {

        }
    }

}
