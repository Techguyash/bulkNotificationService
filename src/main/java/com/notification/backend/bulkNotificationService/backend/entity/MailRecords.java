package com.notification.backend.bulkNotificationService.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MailRecords
{

    @SequenceGenerator(name = "seq_emailId", sequenceName = "seq_emailId", initialValue = 1)
    @Id
    @GeneratedValue(generator ="seq_emailId")
    private int id;

    public MailRecords(String email, Category category)
    {
        this.email = email;
        this.category = category;
    }

    private String email;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;


    public MailRecords()
    {

    }
}
