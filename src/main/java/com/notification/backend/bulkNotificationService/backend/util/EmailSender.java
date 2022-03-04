package com.notification.backend.bulkNotificationService.backend.util;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.util.concurrent.Callable;

@Log
@NoArgsConstructor
@Service
public class EmailSender implements Callable
{
    @Autowired
    JavaMailSender  javaMailSender;



    @Override
    public Object call() throws Exception
    {
        return null;
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
            e.printStackTrace();
             return false;
        }
    }

    public boolean sendWithAttachment(String to, String subject, String bodyContent, boolean isHtml, MultipartFile attachment)
    {
        try
        {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setSubject(subject);
            helper.setText(bodyContent, isHtml);
            helper.setTo(to);
            helper.setFrom("testserver@mail.com");
            helper.addAttachment(attachment.getOriginalFilename(), attachment);
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
