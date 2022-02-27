package com.notification.backend.bulkNotificationService.backend.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface FileUploader
{
    int getFileData(MultipartFile file,String category) throws IOException;
    int getFileData(InputStream file, String category) throws IOException;
}
