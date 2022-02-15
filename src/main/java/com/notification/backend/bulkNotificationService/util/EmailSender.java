package com.notification.backend.bulkNotificationService.util;

import lombok.extern.java.Log;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

@Log
public class EmailSender
{
    public EmailSender()
    {
    }

    private JavaMailSender javaMailSender;

    public EmailSender(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }


    public boolean send(String to,String subject,String bodyContent,boolean isHtml)
    {
        try
        {

           // log.info("Request Received \n Initiating request for +"+to);
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setSubject(subject);
            helper.setText(bodyContent, isHtml);
            helper.setTo(to);
            helper.setFrom("testserver@mail.com");
            javaMailSender.send(mimeMessage);

            return true;
        }
        catch (Exception e)
        {

            return false;
        }




    }
}
