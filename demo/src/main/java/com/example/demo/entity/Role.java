package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role{
    @Id
    @GeneratedValue(generator = "roles_seq")
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(length = 20)
    private String name;



    public Role(String name){
        this.name = name;
    }
    public Role(Integer id){
        this.id = id;
    }

}
