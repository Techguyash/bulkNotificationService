package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmailService
{

    int send(EmailDTO email) throws Exception;
    public int sendWithAttachment(EmailDTO emailDTO, MultipartFile attachment) throws Exception;
    public List<String> getMailList(String category) throws Exception;
}
