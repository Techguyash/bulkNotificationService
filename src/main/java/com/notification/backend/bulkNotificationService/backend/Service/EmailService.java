package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService
{

    int send(EmailDTO email);
    public int sendWithAttachment(EmailDTO emailDTO, MultipartFile attachment) throws Exception;
}
