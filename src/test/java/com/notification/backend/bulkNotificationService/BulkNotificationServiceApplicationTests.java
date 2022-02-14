package com.notification.backend.bulkNotificationService;

import com.notification.backend.bulkNotificationService.Service.EmailService;
import com.notification.backend.bulkNotificationService.model.Email;
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
			Email m1=new Email("Esakki"+i+"@gmail.com","Dummy body message","Subject "+i,false);
			service.send(m1);
		}
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.out.println("\n\n------------------------");
		System.out.println("Time taken :"+between.toMillis() + "millie Seconds\n"
		+"Time taken :"+between.toSeconds()+" seconds");
	}


}
