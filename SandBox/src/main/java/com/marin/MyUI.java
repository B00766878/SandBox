package com.marin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout verLayout = new VerticalLayout();
        final HorizontalLayout horLayout = new HorizontalLayout();
        final HorizontalLayout horBtnLayout = new HorizontalLayout();
        final VerticalLayout verBtnLayout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");
        name.setPlaceholder("eg. John");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            verLayout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        Button btn01 = new Button("Eat Me");
        btn01.addClickListener(e -> {
            Notification.show("OI!!!! " + name.getValue() 
                    + " EAT MY SHORTS!!!!");
        });
        Button btn02 = new Button("Drink Me");
        Button btn03 = new Button("Smell Me");
        Button rstBtn = new Button("Reset");
        rstBtn.addClickListener(e -> {
            verBtnLayout.removeAllComponents();
            verLayout.removeAllComponents();
            horLayout.removeAllComponents();
            verBtnLayout.addComponents(btn01, btn02, btn03, rstBtn);
            verLayout.addComponents(name, button);
            horLayout.addComponents(verBtnLayout, verLayout);

            setContent(horLayout);
            
        });

        verBtnLayout.addComponents(btn01, btn02, btn03, rstBtn);
        verLayout.addComponents(name, button);
        horLayout.addComponents(verBtnLayout, verLayout);
        
        setContent(horLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
