//package com.customerSystem.customerSystem.model;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table
//public class ProductType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "productType")
//    private List<Product> products = new ArrayList<>();
//
//    public ProductType() {
//    }
//
//    public ProductType(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
////    public List<Product> getProducts() {
////        return products;
////    }
//
////    public void setProducts(List<Product> products) {
////        this.products = products;
////    }
//
//    @Override
//    public String toString() {
//        return "ProductType{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
////                ", products=" + products +
//                '}';
//    }
//}
