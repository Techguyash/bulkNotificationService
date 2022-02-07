package com.notification.backend.bulkNotificationService.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Email
{
    private String from;
    private String to;
    private String message;
    private String subject;
    @JsonProperty
    private boolean isHtmlContent;
}
