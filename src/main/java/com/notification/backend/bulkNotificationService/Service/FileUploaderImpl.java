package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.entity.Category;
import com.notification.backend.bulkNotificationService.entity.MailRecords;
import com.notification.backend.bulkNotificationService.repo.CategoryRepo;
import com.notification.backend.bulkNotificationService.repo.MailRecordRepo;
import com.notification.backend.bulkNotificationService.util.ExcelFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploaderImpl implements FileUploader
{
    @Autowired
    ExcelFileReader fileReader;

    @Autowired
    MailRecordRepo mailRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public int getFileData(MultipartFile file,String category) throws IOException
    {
        int count=0;
        List<String> mailList = fileReader.readFileData(file.getInputStream());
        Category categoryName = categoryRepo.findBycategoryName(category);
        List<MailRecords> mailRecords=new ArrayList<>(100);
        for (String mail:mailList)
        {
            MailRecords entity=new MailRecords(mail,categoryName);
            mailRecords.add(entity);
        }
        List<MailRecords> uploadedRecords = mailRepo.saveAll(mailRecords);

        return uploadedRecords.size();
    }
}
