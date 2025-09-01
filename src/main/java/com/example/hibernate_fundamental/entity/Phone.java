package com.example.hibernate_fundamental.entity;

import com.example.hibernate_fundamental.enums.PhoneType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String brand;
    private String model;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phone_type")
    private PhoneType type;


    public Phone() {
    }

    public Phone(String brand, String model, PhoneType type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type=" + type +
                '}';
    }
}
