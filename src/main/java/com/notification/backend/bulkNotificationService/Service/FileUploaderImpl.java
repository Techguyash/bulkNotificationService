package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.util.ExcelFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileUploaderImpl implements FileUploader
{
    @Autowired
    ExcelFileReader fileReader;

    @Override
    public boolean getFileData(MultipartFile file) throws IOException
    {
        List<String> mailList = fileReader.readFileData(file.getInputStream());
        return true;
    }
}
