package com.notification.backend.bulkNotificationService.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PhoneNumber
{
    @SequenceGenerator(name = "seq_phoneRecords",initialValue = 1,sequenceName = "seq_phoneRecords")

    @Id
    @GeneratedValue(generator = "seq_phoneRecords")
    private long id;
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
