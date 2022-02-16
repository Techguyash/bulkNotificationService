package com.notification.backend.bulkNotificationService.controller;

import com.notification.backend.bulkNotificationService.Service.EmailService;
import com.notification.backend.bulkNotificationService.model.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EmailController
{
    @Autowired
    private EmailService emailService;

    @GetMapping("/status")
    public ResponseEntity<String> statusCheck()
    {
        return new ResponseEntity<String>("Up and running", HttpStatus.OK);
    }

    @PostMapping("/mail")
    public ResponseEntity emailRequest(@RequestBody EmailDTO mailDto)
    {
        int send = emailService.send(mailDto);
        if (send>0)
        {
            return new ResponseEntity(send+" mails sent successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("Send Successfully", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
