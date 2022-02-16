package com.notification.backend.bulkNotificationService.backend.util;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Log
@NoArgsConstructor
@Component
public class EmailSender
{


    @Autowired
    JavaMailSender javaMailSender;


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
            e.printStackTrace();
             return false;
        }




    }
}
