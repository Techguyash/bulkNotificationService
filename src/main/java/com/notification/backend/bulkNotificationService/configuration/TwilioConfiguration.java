package com.notification.backend.bulkNotificationService.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
@NoArgsConstructor
public class TwilioConfiguration
{
    private String account_sid;
    private String auth_token;
    private String phone_number;
}
