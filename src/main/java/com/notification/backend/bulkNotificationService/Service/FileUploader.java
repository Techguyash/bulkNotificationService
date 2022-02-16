package com.notification.backend.bulkNotificationService.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploader
{
    boolean getFileData(MultipartFile file,String category) throws Exception;
}
