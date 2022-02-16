package com.notification.backend.bulkNotificationService.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploader
{
    int getFileData(MultipartFile file,String category) throws IOException;
}
