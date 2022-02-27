package com.notification.backend.bulkNotificationService.backend.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIRestError
{
	private String message;
	private String status;
	private HashMap<String, String> info;
}
