package com.notification.backend.bulkNotificationService.controller;

import com.notification.backend.bulkNotificationService.Service.EmailService;
import com.notification.backend.bulkNotificationService.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/app/api")
public class Controller
{
    @Autowired
    private EmailService emailService;

    @PostMapping("/mail")
    public ResponseEntity emailRequest(@RequestBody Email content)
    {
        boolean send = emailService.send(content);
        if(send)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity("Send Successfully",HttpStatus.EXPECTATION_FAILED);
    }
}
