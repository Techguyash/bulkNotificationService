package com.notification.backend.bulkNotificationService;

import com.notification.backend.bulkNotificationService.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;

@SpringBootTest
class BulkNotificationServiceApplicationTests {


	@Autowired
	EmailService service;

	@Test
	void mailTest()
	{
		Instant start=Instant.now();
		for(int i=1;i<=50;i++)
		{

		
		}
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.out.println("\n\n------------------------");
		System.out.println("Time taken :"+between.toMillis() + "millie Seconds\n"
		+"Time taken :"+between.toSeconds()+" seconds");
	}


}
