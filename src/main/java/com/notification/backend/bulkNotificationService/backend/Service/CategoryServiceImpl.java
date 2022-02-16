package com.notification.backend.bulkNotificationService.backend.Service;


import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.model.CategoryDTO;
import com.notification.backend.bulkNotificationService.backend.repo.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryRepo categoryRepo;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Category createCategory(CategoryDTO dto)
    {
        Category mappedEntity = modelMapper.map(dto, Category.class);
        mappedEntity.setCreatedOn(LocalDate.now());
        Category save = categoryRepo.save(mappedEntity);
        return save;
    }

    @Override
    public Category getCategory(int id) throws Exception
    {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<Category> getAllCategory() throws Exception
    {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Category category) throws Exception
    {
        if (category != null)
        {
            return categoryRepo.save(category);

        }
        else
        {
            throw new Exception("Category cannot be null");
        }
    }

    @Override
    public boolean deleteCategory(int categoryId) throws Exception
    {
        if (getCategory(categoryId) != null)
        {
            categoryRepo.deleteById(categoryId);
            return true;
        }
        return false;

    }

    @Override
    public long categoryTotalCount() throws Exception
    {
        return categoryRepo.count();
    }
}
