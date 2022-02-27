package com.notification.backend.bulkNotificationService.backend.repo;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.MailRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRecordRepo extends JpaRepository<MailRecords,Integer>
{
    List<MailRecords> findAllBycategory( Category category);
}
