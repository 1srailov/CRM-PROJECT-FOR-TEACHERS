package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "branch_seq")
    @SequenceGenerator(name = "branch_seq", sequenceName = "branch_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;
}
