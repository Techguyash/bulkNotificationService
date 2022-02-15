package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.model.EmailDTO;

public interface EmailService
{

    boolean send(EmailDTO email);
}
