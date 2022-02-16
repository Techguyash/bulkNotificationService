package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.entity.Category;
import com.notification.backend.bulkNotificationService.entity.MailRecords;
import com.notification.backend.bulkNotificationService.repo.MailRecordRepo;
import com.notification.backend.bulkNotificationService.util.ExcelFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    CategoryService categoryService;

    @Override
    public boolean getFileData(MultipartFile file,String category) throws Exception
    {
        List<String> mailList = fileReader.readFileData(file.getInputStream());
        Category categoryEntity = categoryService.getCategoryByName(category);
        List<MailRecords> mailRecordsList=new ArrayList<>(100);
        for(String mail:mailList)
        {
            MailRecords mailRecords=new MailRecords(mail,categoryEntity);
            mailRecordsList.add(mailRecords);
        }
        mailRepo.saveAll(mailRecordsList);

        return true;
    }
}
