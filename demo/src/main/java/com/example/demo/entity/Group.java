package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
public class Group{

    @Id
    @GeneratedValue(generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "groups_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_id")
    private String photoId;
}
