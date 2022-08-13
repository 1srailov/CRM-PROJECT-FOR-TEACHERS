package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task{

    @Id
    @GeneratedValue(generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "tasks_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "name")
    private String name;

}
