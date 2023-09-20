package com.customersystem.customersystem.modeldto;

import java.time.LocalDate;

public class CustomerDto {
    private String name;
    private String NIK;
    private String email;
    private String phone;
    private String Address;
    private LocalDate DOB;

    public CustomerDto() {
    }

    public CustomerDto(String name, String NIK, String email, String phone, String address, LocalDate DOB) {
        this.name = name;
        this.NIK = NIK;
        this.email = email;
        this.phone = phone;
        Address = address;
        this.DOB = DOB;
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
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", NIK='" + NIK + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", Address='" + Address + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
