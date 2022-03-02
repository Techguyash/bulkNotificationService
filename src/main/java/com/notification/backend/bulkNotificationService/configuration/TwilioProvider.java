package com.notification.backend.bulkNotificationService.configuration;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioProvider
{
    TwilioConfiguration twilioProperties;

    @Autowired
    public TwilioProvider(TwilioConfiguration twilioProperties)
    {
        this.twilioProperties = twilioProperties;
        Twilio.init(twilioProperties.getAccount_sid(),twilioProperties.getAuth_token());
    }


}
