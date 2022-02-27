package com.notification.backend.bulkNotificationService.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class MailRecords
{
    @SequenceGenerator(name = "seq_emailId", sequenceName = "seq_emailId", initialValue = 1)
    @Id
    @GeneratedValue(generator ="seq_emailId")
    private int id;
    private String email;

    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    public MailRecords( String email, Category category )
    {
        this.email=email;
        this.category=category;
    }
}