package com.notification.backend.bulkNotificationService;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Theme(value = "myapp")
@PWA(name = "Broadcast Messenger", shortName = "BroadcastMessenger", offlineResources = {"images/logo.png"})
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class BulkNotificationServiceApplication extends SpringBootServletInitializer implements AppShellConfigurator
{

	public static void main(String[] args) {
		SpringApplication.run(BulkNotificationServiceApplication.class, args);
	}

}
