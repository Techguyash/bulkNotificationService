package com.notification.backend.bulkNotificationService.frontend.views.importData;

import com.notification.backend.bulkNotificationService.frontend.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = ImportData.ROUTE,layout = MainLayout.class)
@RouteAlias(value = "",layout = MainLayout.class)
public class ImportData extends VerticalLayout
{
    public  static final String ROUTE="importdata";
    public static final String TITLE="Import Data";

    public ImportData()
    {
        TextField textField=new TextField("Name");
        Button button=new Button("Say hello");
        HorizontalLayout layout=new HorizontalLayout();
        layout.add(textField,button);
        add(layout);
        layout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        button.addClickListener(e->{
            Notification.show("Greetings "+textField.getValue());
        });
    }
}
