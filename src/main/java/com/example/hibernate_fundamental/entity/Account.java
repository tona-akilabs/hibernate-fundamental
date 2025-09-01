package com.example.hibernate_fundamental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private Double credit;
    private Double rate;
    @Formula(value = "credit * rate")
    //@Formula(value = "CASE WHEN credit IS NULL OR rate IS NULL THEN NULL ELSE credit * rate END")
    //@Formula("coalesce(credit, 0) * coalesce(rate, 0)")
    private Double interest;

    public Account() {}

    public Account(Double credit, Double rate) {
        this.credit = credit;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", credit=" + credit +
                ", rate=" + rate +
                ", interest=" + interest +
                '}';
    }
}
