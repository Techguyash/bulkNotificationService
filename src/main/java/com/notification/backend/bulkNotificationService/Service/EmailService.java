package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.model.Email;

public interface EmailService
{

    boolean send(Email email);
}
