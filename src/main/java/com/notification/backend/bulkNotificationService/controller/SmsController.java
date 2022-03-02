package com.notification.backend.bulkNotificationService.controller;


import com.notification.backend.bulkNotificationService.apiresponse.ResponseUtil;
import com.notification.backend.bulkNotificationService.backend.Service.SmsService;
import com.notification.backend.bulkNotificationService.backend.model.SmsDTO;
import com.notification.backend.bulkNotificationService.backend.rest.APIRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sms")
public class SmsController
{
    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService)
    {
        this.smsService = smsService;
    }

    @PostMapping
    public ResponseEntity<APIRestResponse> sendSMS(@RequestBody SmsDTO smsDTO)
    {
        APIRestResponse response=null;
        try
        {
            List<String> sentNumber = smsService.sendSMS(smsDTO);
            response.setData(sentNumber);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response= ResponseUtil.returnApiResponse(null,e.getMessage());
        }
        return new ResponseEntity<>(response,response.getIsError()? HttpStatus.INTERNAL_SERVER_ERROR:HttpStatus.OK);
    }
}
