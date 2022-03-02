package com.notification.backend.bulkNotificationService.backend.util;

import com.notification.backend.bulkNotificationService.backend.model.SmsRequest;
import com.notification.backend.bulkNotificationService.configuration.TwilioConfiguration;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TwilioSmsService
{


    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsService(TwilioConfiguration twilioProperties)
    {

        this.twilioConfiguration = twilioProperties;
    }



    public boolean sendTwilioSMS(SmsRequest smsRequest) throws TwilioException
    {
        if(isPhoneNumber(smsRequest.getPhoneNumber()))
        {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getPhone_number());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            return true;
        }
        else
        {

            throw new IllegalArgumentException("phone number not valid");
        }

    }

    private boolean isPhoneNumber(String phoneNumber)
    {

            return true;

    }


}
