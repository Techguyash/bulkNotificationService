package com.notification.backend.bulkNotificationService.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Email
{
    public Email(String to, String message, String subject, boolean isHtmlContent) {
        this.to = to;
        this.message = message;
        this.subject = subject;
        this.isHtmlContent = isHtmlContent;
    }

    public Email() {
    }

    private String from;
    private String to;
    private String message;
    private String subject;
    @JsonProperty
    private boolean isHtmlContent;
}
