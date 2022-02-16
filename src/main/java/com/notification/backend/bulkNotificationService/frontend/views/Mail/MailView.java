package com.notification.backend.bulkNotificationService.frontend.views.Mail;


import com.notification.backend.bulkNotificationService.frontend.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route(value = MailView.ROUTE,layout = MainLayout.class)
public class MailView extends VerticalLayout implements BeforeEnterObserver
{
    public  static final String ROUTE="mail";
    public static final String TITLE="Import Data";

    public MailView()
    {
        add(new H1("Mail data view"));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent)
    {

    }
}
