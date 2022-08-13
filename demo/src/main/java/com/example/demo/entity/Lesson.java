package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {
    @Id
    @GeneratedValue(generator = "lesson_seq")
    @SequenceGenerator(name = "lesson_seq", sequenceName = "lessons_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "name")
    private String name;

    @Column(name = "month")
    private Integer month;

    @Column(name = "date")
    private Date date;

    @ManyToMany
    List<Student> students;

}
