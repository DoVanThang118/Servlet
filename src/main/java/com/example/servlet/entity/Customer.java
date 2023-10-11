package com.example.servlet.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String address;

    public Customer(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Customer() {
    }

    public Customer(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
