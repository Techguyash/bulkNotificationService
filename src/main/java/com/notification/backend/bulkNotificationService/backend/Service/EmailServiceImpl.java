package com.notification.backend.bulkNotificationService.backend.Service;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.MailRecords;
import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import com.notification.backend.bulkNotificationService.backend.repo.CategoryRepo;
import com.notification.backend.bulkNotificationService.backend.repo.MailRecordRepo;
import com.notification.backend.bulkNotificationService.backend.util.EmailSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService
{

    @Autowired
    MailRecordRepo mailRecordRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    EmailSender sender;


    @Override
    @Async
    public int send(EmailDTO emailDTO)
    {
        int count = 0;
        try
        {
            List<String> mailList = getMailList(emailDTO.getCategory());
//            EmailSender sender=new EmailSender();
            for (String mail : mailList)
            {

                    if (sender.send(mail, emailDTO.getSubject(), emailDTO.getMessage(), emailDTO.isHtmlContent()))
                    {
                        count++;
                    }
            }
            return count;
        }
        catch (Exception e)
        {
            log.error("Failed  message :" + e.getLocalizedMessage());
            return count;
        }
    }

    public int sendWithAttachment(EmailDTO emailDTO, MultipartFile attachment) throws Exception
    {
        int count=0;
        List<String> mailList = getMailList(emailDTO.getCategory());
//            EmailSender sender=new EmailSender();
        for (String mail : mailList)
        {

            if (sender.sendWithAttachment(mail, emailDTO.getSubject(), emailDTO.getMessage(), emailDTO.isHtmlContent(),attachment))
            {
                count++;
            }
        }
        return count;
    }




    public List<String> getMailList(String category)
    {
        Category categoryName = categoryRepo.findBycategoryName(category);
        List<MailRecords> allBycategory = mailRecordRepo.findAllBycategory(categoryName);
        List<String> mailList = allBycategory.stream().map(mailRecords -> mailRecords.getEmail()).collect(
                Collectors.toList());
        return mailList;
    }
}
