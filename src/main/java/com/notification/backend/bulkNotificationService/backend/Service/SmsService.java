package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.model.SmsDTO;
import com.twilio.exception.TwilioException;

import java.util.List;

public interface SmsService
{
    List<String> sendSMS(SmsDTO smsDTO) throws TwilioException,Exception;
}
