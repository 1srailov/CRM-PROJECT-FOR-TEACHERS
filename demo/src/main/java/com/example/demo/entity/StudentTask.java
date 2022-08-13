package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_tasks")
@AllArgsConstructor
@NoArgsConstructor
public class StudentTask {

    @Id
    @GeneratedValue(generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "ball")
    private Integer ball;

    @Column(name = "description")
    private String description;
}
