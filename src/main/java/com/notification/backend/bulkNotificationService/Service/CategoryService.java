package com.notification.backend.bulkNotificationService.Service;

import com.notification.backend.bulkNotificationService.entity.Category;
import com.notification.backend.bulkNotificationService.model.CategoryDTO;

import java.util.List;

public interface CategoryService
{
    Category createCategory(CategoryDTO category);
    Category getCategory(int id) throws Exception;
    List<Category> getAllCategory() throws Exception;
    Category updateCategory(Category category) throws Exception;
    boolean deleteCategory(int categoryId) throws Exception;
    long categoryTotalCount() throws Exception;

}
