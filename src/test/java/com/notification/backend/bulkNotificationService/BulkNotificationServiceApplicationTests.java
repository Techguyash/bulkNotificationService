package com.notification.backend.bulkNotificationService;

import com.notification.backend.bulkNotificationService.Service.EmailServiceImpl;
import com.notification.backend.bulkNotificationService.model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;

@SpringBootTest
class BulkNotificationServiceApplicationTests {


	@Autowired
	EmailServiceImpl service;

	@Test
	void mailTest()
	{
		Instant start=Instant.now();
		String msg="Contrary to popular belief, Lorem Ipsum is not simply random text." +
				" It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 " +
				"years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia," +
				" looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage," +
				" and going through the cites of the word in classical literature, discovered the " +
				"undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de " +
				"Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in " +
				"45 BC. This book is a treatise on the theory of ethics, very popular during the Renais" +
				"sance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line" +
				" in section 1.10.32.\n" +
				"\n" +
				"The standard chunk of Lorem Ipsum used since the 1500s is reproduced below f" +
				"or those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" " +
				"by Cicero are also reproduced in their exact original form, accompanied by English ver" +
				"sions from the 1914 translation by H. Rackham.";
		int i;
		for(i=1;i<=50;i++)
		{
			Email m1=new Email("Esakki"+i+"@gmail.com",msg,"Subject "+i,false);
			service.send(m1);
		}
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.out.println("\n------------------------");
		System.out.println("\n Time taken :"+between.toMillis()+" milli seconds"+"\n Time taken :"+between.toSeconds()+" seconds"+"\n Time taken :"+between.toMinutes()+" minutes");
	}


}
