package com.notification.backend.bulkNotificationService;

import com.notification.backend.bulkNotificationService.Service.CategoryService;
import com.notification.backend.bulkNotificationService.Service.EmailService;
import com.notification.backend.bulkNotificationService.entity.Category;
import com.notification.backend.bulkNotificationService.model.CategoryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BulkNotificationServiceApplicationTests {


	@Autowired
	EmailService service;

	@Autowired
	CategoryService categoryService;

	@Test
	void CategoryCRUD()
	{
		//create category
		CategoryDTO categoryDTO=new CategoryDTO("Category1","Test category",true);
		Category returnCategory = categoryService.createCategory(categoryDTO);
		//Category expectedCategory=new Category(1,"Category1","Test category", LocalDate.now(),true);
		//Assertions.assertEquals(returnCategory,expectedCategory);
	}


}
