package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int projects;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users;

    public void add(User user){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(user);
    }
}
