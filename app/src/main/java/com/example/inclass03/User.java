package com.example.inclass03;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String email;
    int Id;
    String dept;

    public User(String name, String email, int id, String dept) {
        this.name = name;
        this.email = email;
        this.Id = id;
        this.dept = dept;
    }

}
