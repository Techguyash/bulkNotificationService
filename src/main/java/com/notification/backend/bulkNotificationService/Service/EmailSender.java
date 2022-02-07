package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.entity.Email;

public interface EmailSender
{

    boolean send(Email email);
}
