package com.notification.backend.bulkNotificationService.backend.controller;

import com.notification.backend.bulkNotificationService.backend.Service.EmailService;
import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            return new ResponseEntity("failed", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("mail/attached")
    public ResponseEntity emailWithAttachment(@RequestPart("data") EmailDTO mailDto,@RequestPart("file") MultipartFile file)
    {

        int send = 0;
        try
        {
            send = emailService.sendWithAttachment(mailDto,file);
            if (send>0)
            {
                return new ResponseEntity(send+" mails sent successfully",HttpStatus.OK);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity("failed", HttpStatus.EXPECTATION_FAILED);
    }


}
