package com.notification.backend.bulkNotificationService.controller;

import com.notification.backend.bulkNotificationService.Service.EmailService;
import com.notification.backend.bulkNotificationService.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/app/api")
public class Controller
{
    @Autowired
    private EmailService emailService;

    @GetMapping("/status")
    public ResponseEntity<String> statusCheck()
    {
        return new ResponseEntity<>("Up and running", HttpStatus.OK);
    }

    @PostMapping("/mail")
    public ResponseEntity emailRequest(@RequestBody Email content)
    {
        boolean send = emailService.send(content);
        if (send)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("Send Successfully", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
