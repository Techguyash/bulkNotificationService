package com.notification.backend.bulkNotificationService.backend.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailDTO
{
    public EmailDTO(String category, String message, String subject, boolean isHtmlContent) {
        this.category = category;
        this.message = message;
        this.subject = subject;
        this.isHtmlContent = isHtmlContent;
    }

    public EmailDTO() {
    }
    private String category;
    private String message;
    private String subject;
    @JsonProperty
    private boolean isHtmlContent;

}
