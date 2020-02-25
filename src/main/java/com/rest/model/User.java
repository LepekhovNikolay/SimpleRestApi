package com.rest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    private @Id @GeneratedValue Long id;
    private String name;
    private Roles role;

    public User() {}

    public User(String name, Roles role) {
        this.name = name;
        this.role = role;
    }
}
