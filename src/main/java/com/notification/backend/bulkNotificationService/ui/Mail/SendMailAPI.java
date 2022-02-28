package com.notification.backend.bulkNotificationService.ui.Mail;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SendMailAPI
{
	@Value("${server.port}")
	String serverPort;

	public static String API_GET_ALL_CATEGORY;
	public static String API_SEND_MAIL;
	public static String API_SEND_MAIL_ATTACHMENT;


	@PostConstruct
	public void init()
	{
		try{
			API_GET_ALL_CATEGORY="http://localhost:"+serverPort+"/category/all";
			API_SEND_MAIL="http://localhost:"+serverPort+"/mail";
			API_SEND_MAIL_ATTACHMENT="http://localhost:"+serverPort+"/mail/attached";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
