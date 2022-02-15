package com.notification.backend.bulkNotificationService.controller;

import com.notification.backend.bulkNotificationService.Service.CategoryService;
import com.notification.backend.bulkNotificationService.entity.Category;
import com.notification.backend.bulkNotificationService.model.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;

    ModelMapper mapper=new ModelMapper();

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryDTO dto)
    {
        try
        {
            Category category = categoryService.createCategory(dto);
            return new ResponseEntity(category, HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity getCategory(@RequestParam("id") int id)
    {
        try
        {
            Category category = categoryService.getCategory(id);
            return new ResponseEntity(category,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/all")
    public ResponseEntity getAllCategory()
    {
        try
        {
            List<Category> category = categoryService.getAllCategory();
            return new ResponseEntity(category,HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity updateCategory(@RequestBody Category categ)
    {
        try
        {
            Category category = categoryService.updateCategory(categ);
            return new ResponseEntity(category, HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteCategory(@RequestParam("id")int id)
    {
        try
        {
            if(categoryService.deleteCategory(id))
            return new ResponseEntity("success", HttpStatus.OK);
            else
                return new ResponseEntity("failed", HttpStatus.CONFLICT);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
