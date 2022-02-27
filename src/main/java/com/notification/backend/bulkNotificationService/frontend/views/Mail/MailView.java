package com.notification.backend.bulkNotificationService.frontend.views.Mail;


import com.notification.backend.bulkNotificationService.backend.Service.CategoryService;
import com.notification.backend.bulkNotificationService.backend.Service.EmailService;
import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import com.notification.backend.bulkNotificationService.backend.rest.APIRestResponse;
import com.notification.backend.bulkNotificationService.frontend.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value=MailView.ROUTE, layout=MainLayout.class)
public class MailView extends VerticalLayout implements BeforeEnterObserver
{
	public static final String ROUTE="mail";
	public static final String TITLE="Import Data";


	EmailService emailService;
	CategoryService categoryService;

	public MailView( EmailService emailService, CategoryService categoryService )
	{
		this.emailService=emailService;
		this.categoryService=categoryService;
	}

	MailPresenter mailPresenter;

	public MailView()
	{
		try
		{
			TextField subjectFld=new TextField("Subject");
			TextArea message=new TextArea("Message");
			ComboBox<Category> categoryComboBox=new ComboBox<>("category");
			subjectFld.setRequired(true);
			subjectFld.setRequiredIndicatorVisible(true);
			message.setRequired(true);
			message.setRequiredIndicatorVisible(true);
			categoryComboBox.setRequired(true);
			categoryComboBox.setRequiredIndicatorVisible(true);

			mailPresenter=new MailPresenter();
			List<Category> allCategory=mailPresenter.getAllCategory();
			categoryComboBox.setItems(allCategory);
			categoryComboBox.setItemLabelGenerator(Category::getCategoryName);

			Button btnSend=new Button("Send");
			btnSend.addClickListener(event ->
			{
				EmailDTO entity=new EmailDTO(categoryComboBox.getValue().getCategoryName(), message.getValue(), subjectFld.getValue(), false);
				APIRestResponse response = mailPresenter.sendEmail(entity);
				if ( response.getIsSuccess()==true && response.getIsError()==false)
				{
					Notification.show(response.getData().toString(), 8000, Notification.Position.BOTTOM_CENTER);
					subjectFld.setValue("");
					subjectFld.setInvalid(false);
					message.setValue("");
					message.setInvalid(false);
				}
				else
				{
					Notification.show("Failed to send"+response.getErrorMessage(), 8000, Notification.Position.BOTTOM_CENTER);
				}
			});
			add(subjectFld, message,categoryComboBox, btnSend);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void beforeEnter( BeforeEnterEvent beforeEnterEvent )
	{

	}
}
