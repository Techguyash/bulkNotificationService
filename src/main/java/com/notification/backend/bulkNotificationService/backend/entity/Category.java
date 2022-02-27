package com.notification.backend.bulkNotificationService.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Category
{
    @SequenceGenerator(name = "seq_categoryId", sequenceName = "seq_categoryId", initialValue = 1)
    @Id
    @GeneratedValue(generator = "seq_categoryId")
    private int CategoryId;
    @Column(unique = true)
    private String categoryName;
    private String description;
    private LocalDate createdOn;
    private boolean active;
}
