package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.model.EmailDTO;

public interface EmailService
{

    int send(EmailDTO email);
}
