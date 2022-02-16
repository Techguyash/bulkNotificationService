package com.notification.backend.bulkNotificationService.backend.repo;

import com.notification.backend.bulkNotificationService.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>
{
    Category findBycategoryName(String categoryName);
}
