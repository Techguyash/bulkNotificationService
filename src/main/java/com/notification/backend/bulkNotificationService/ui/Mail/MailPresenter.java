package com.notification.backend.bulkNotificationService.ui.Mail;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.backend.bulkNotificationService.backend.entity.Category;
import com.notification.backend.bulkNotificationService.backend.model.EmailDTO;
import com.notification.backend.bulkNotificationService.backend.rest.APIRestResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailPresenter
{

	public List<Category> getAllCategory()
	{
		List<Category> categories=new ArrayList<>();
		try{
			RestTemplate template=new RestTemplate();
			String response=template.getForObject(SendMailAPI.API_GET_ALL_CATEGORY, String.class);
			JSONObject obj=new JSONObject(response);
			JSONArray data=obj.getJSONArray("data");
			ObjectMapper objectMapper=new ObjectMapper();
			objectMapper.findAndRegisterModules();
			categories=objectMapper.readValue(data.toString(), new TypeReference<List<Category>>()
			{
			});


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return categories;
	}

	public APIRestResponse sendEmail(EmailDTO mailDto)
	{
		APIRestResponse restResponse=new APIRestResponse();
		try{
			RestTemplate restTemplate=new RestTemplate();
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<EmailDTO> entity=new HttpEntity<>(mailDto,httpHeaders);
			String response = restTemplate.exchange(SendMailAPI.API_SEND_MAIL, HttpMethod.POST, entity, String.class).getBody();

			JSONObject responseObject=new JSONObject(response);
			restResponse.setIsSuccess(responseObject.getBoolean("isSuccess"));
			restResponse.setErrorMessage(String.valueOf(responseObject.get("errorMessage")));
			restResponse.setData(responseObject.get("data"));

		}
		catch (Exception e)
		{
			restResponse.setIsSuccess(false);
			e.printStackTrace();
		}
		return restResponse;
	}
}
