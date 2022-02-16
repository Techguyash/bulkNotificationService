package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;

public interface EmailService
{

    int send(EmailDTO email);
}
