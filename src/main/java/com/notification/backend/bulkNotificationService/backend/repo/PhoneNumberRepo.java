package com.notification.backend.bulkNotificationService.backend.repo;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhoneNumberRepo extends JpaRepository<PhoneNumber,Long>
{
    List<PhoneNumber> findAllBycategory(Category category);
}

