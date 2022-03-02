package com.notification.backend.bulkNotificationService.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmsRequest
{
    private final String phoneNumber;
    private final String message;


}
