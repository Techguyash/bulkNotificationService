package com.notification.backend.bulkNotificationService.controller;

import com.notification.backend.bulkNotificationService.Service.FileUploader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController
{
    FileUploader fileHandler;

    public FileController(FileUploader fileHandler)
    {
        this.fileHandler = fileHandler;
    }

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam(name = "file") MultipartFile file,@RequestParam("category") String category)
    {
        try
        {

            int uploadedCount = fileHandler.getFileData(file,category);
            if(uploadedCount>0)
                return new ResponseEntity(uploadedCount+" mails uploaded success", HttpStatus.OK);
            else
                return new ResponseEntity("upload failed, please check logs", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        catch (Exception e)
        {
            return new ResponseEntity("upload failed, please check logs", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
