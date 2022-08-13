package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "types")
@AllArgsConstructor
@NoArgsConstructor
public class CourseType {

    @Id
    @GeneratedValue(generator = "type_seq")
    @SequenceGenerator(name = "type_seq", sequenceName = "type_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


}
