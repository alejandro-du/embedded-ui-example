package org.test;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.embedded.VaadinUIComponent;

import javax.servlet.annotation.WebServlet;

/**
 * @author Alejandro Duarte
 */
@Theme(ValoTheme.THEME_NAME)
public class HostUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VaadinUIComponent ui1 = new VaadinUIComponent("http://localhost:9001");
        VaadinUIComponent ui2 = new VaadinUIComponent("http://localhost:9002");

        HorizontalSplitPanel split = new HorizontalSplitPanel(ui1, ui2);
        split.setSizeFull();
        setContent(split);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HostUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
