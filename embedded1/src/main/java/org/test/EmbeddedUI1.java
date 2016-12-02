package org.test;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridBasedCrudComponent;

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

}
