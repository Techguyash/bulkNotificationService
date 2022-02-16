package com.notification.backend.bulkNotificationService.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO
{
     @NotNull(message = "category name must not be null")
     String categoryName;
     @NotNull(message = "category description must not be null")
     String description;
     @JsonProperty()
     @NotNull(message = "category status must not be null")
     boolean active;
}
