package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "groups_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private Integer lastname;

    @Column(name = "telegram_username")
    private String telegramUsername;

    @Column(name = "phone_number")
    private String phoneNumber;

}
