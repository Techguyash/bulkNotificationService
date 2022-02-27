package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.MailRecords;
import com.notification.backend.bulkNotificationService.backend.repo.CategoryRepo;
import com.notification.backend.bulkNotificationService.backend.repo.MailRecordRepo;
import com.notification.backend.bulkNotificationService.backend.util.ExcelFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploaderImpl implements FileUploader {
    @Autowired
    ExcelFileReader fileReader;

    @Autowired
    MailRecordRepo mailRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public int getFileData(MultipartFile file, String category) throws IOException {
        int count = 0;
        List<String> mailList = fileReader.readFileData(file.getInputStream());
        Category categoryName = categoryRepo.findBycategoryName(category);
        List<MailRecords> mailRecords = new ArrayList<>(100);
        for (String mail : mailList) {
            MailRecords entity = new MailRecords(mail, categoryName);
            mailRecords.add(entity);
        }
        List<MailRecords> uploadedRecords = mailRepo.saveAll(mailRecords);

        return uploadedRecords.size();
    }

    @Override
    @Transactional
    public int getFileData(InputStream file, String category) throws IOException
    {
        Category categoryName = categoryRepo.findBycategoryName(category);
        List<String> mailList = fileReader.readFileData(file);
        List<MailRecords> mailRecords = new ArrayList<>(100);
        for (String mail : mailList) {
            MailRecords entity = new MailRecords(mail, categoryName);
            mailRecords.add(entity);
        }
        List<MailRecords> uploadedRecords = mailRepo.saveAll(mailRecords);

        return uploadedRecords.size();
    }
}
