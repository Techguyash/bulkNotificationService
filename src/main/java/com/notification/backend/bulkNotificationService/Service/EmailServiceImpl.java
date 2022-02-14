package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.model.Email;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService
{


    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public boolean send(Email content)
    {
        try
        {
            log.info("Request Received \n Initiating request for +"+content.getTo());
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setSubject(content.getMessage());
             helper.setText(content.getMessage(), true);
            helper.setTo(content.getTo());
            helper.setFrom("testserver@mail.com");
            javaMailSender.send(mimeMessage);
            log.info("Mail sent to "+content.getTo());
            return true;
        }
        catch (Exception e)
        {
            log.error("Failed  message :"+e.getLocalizedMessage());
            return false;
        }




    }
}
