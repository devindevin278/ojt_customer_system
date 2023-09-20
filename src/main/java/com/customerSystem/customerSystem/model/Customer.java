package com.customersystem.customersystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cin;

    private String name;
    private String NIK;
    private String email;
    private String phone;
    private String address;
    private LocalDate DOB;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Product> products = new ArrayList<>();

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    public Customer(String name, String NIK, String email, String phone, String address, LocalDate DOB) {
        this.name = name;
        this.NIK = NIK;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.DOB = DOB;
    }

    public Customer(Long cin, String name, String email, String phone, String address) {
        this.cin = cin;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer() {
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cin=" + cin +
                ", name='" + name + '\'' +
                ", NIK='" + NIK + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", Address='" + address + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
