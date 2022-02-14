package com.notification.backend.bulkNotificationService.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploader
{
    boolean getFileData(MultipartFile file) throws IOException;
}
