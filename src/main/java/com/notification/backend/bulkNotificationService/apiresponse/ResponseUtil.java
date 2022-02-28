package com.notification.backend.bulkNotificationService.apiresponse;

import com.notification.backend.bulkNotificationService.backend.rest.APIRestResponse;

public class ResponseUtil
{
	public synchronized  static APIRestResponse returnApiResponse(APIRestResponse response,String errMsg)
	{
		if(response ==null || response.getIsError())
		{
			if(response ==null)
			{
				response=new APIRestResponse();
			}
			response.setIsError(Boolean.TRUE);
			response.setIsSuccess(Boolean.FALSE);
			response.setErrorMessage(errMsg);
			response.setData(null);
		}
		return response;
	}
}
