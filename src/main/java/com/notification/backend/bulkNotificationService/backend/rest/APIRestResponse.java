package com.notification.backend.bulkNotificationService.backend.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class APIRestResponse
{
	private Boolean isSuccess = true;

	private Boolean isError = false;

	private String errorMessage = null;

	private Object data;

	public APIRestResponse( Object data )
	{
		this.data=data;
	}
}
