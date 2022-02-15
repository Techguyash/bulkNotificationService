package com.notification.backend.bulkNotificationService.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<MailRecords> mailRecords = new ArrayList<>();


}
