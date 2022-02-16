package com.notification.backend.bulkNotificationService.frontend.views;


import com.notification.backend.bulkNotificationService.frontend.views.Mail.MailView;
import com.notification.backend.bulkNotificationService.frontend.views.importData.ImportData;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;



public class MainLayout extends AppLayout
{
    public MainLayout()
    {
       addToNavbar(new DrawerToggle());
       addToNavbar(new H2("BroadCast Messenger"));

       final VerticalLayout menubar=new VerticalLayout();
       menubar.add(new RouterLink(ImportData.ROUTE,ImportData.class));
       menubar.add(new RouterLink(MailView.ROUTE,MailView.class));
       menubar.add(new RouterLink("Image compressor",MailView.class));

       addToDrawer(menubar);


    }
}
