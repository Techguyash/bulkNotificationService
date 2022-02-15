package com.notification.backend.bulkNotificationService.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailDTO
{


    public EmailDTO() {
    }


    private String category;
    private String message;
    private String subject;
    @JsonProperty
    private boolean isHtmlContent;
}
