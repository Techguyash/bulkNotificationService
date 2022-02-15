package com.notification.backend.bulkNotificationService.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CategoryDTO
{
     @NotNull(message = "category name must not be null")
     String categoryName;
     @NotNull(message = "category description must not be null")
     String description;
     @NotNull(message = "category status must not be null")
     boolean active;
     LocalDate createdOn;
}
