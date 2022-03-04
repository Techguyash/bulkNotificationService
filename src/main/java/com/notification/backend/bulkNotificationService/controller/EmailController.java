package com.notification.backend.bulkNotificationService.controller;

import com.notification.backend.bulkNotificationService.backend.Service.EmailService;
import com.notification.backend.bulkNotificationService.apiresponse.ResponseUtil;
import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import com.notification.backend.bulkNotificationService.backend.rest.APIRestResponse;
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
    public ResponseEntity<APIRestResponse> emailRequest(@RequestBody EmailDTO mailDto)
    {
        APIRestResponse response=null;
        try
        {
            int send = emailService.send(mailDto);
            response=new APIRestResponse();
            if (send > 0)
            {
                    response.setData(send+" mail sent successfully");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            response= ResponseUtil.returnApiResponse(null,e.getMessage());
        }
        return new ResponseEntity<>(response,response.getIsError()?HttpStatus.INTERNAL_SERVER_ERROR:HttpStatus.OK);
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
