package com.example.hibernate_fundamental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.sql.Clob;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private Clob warranty; // Character Large Object

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clob getWarranty() {
        return warranty;
    }

    public void setWarranty(Clob warranty) {
        this.warranty = warranty;
    }
}
