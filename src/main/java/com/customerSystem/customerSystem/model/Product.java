package com.customerSystem.customerSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table
public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long accountId;

    @EmbeddedId
    private Product_ProductType compositekey;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
//    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Product() {
    }

    public Product(Product_ProductType compositekey, Date created, Customer customer, Status status) {
        this.compositekey = compositekey;
        this.created = created;
        this.customer = customer;
        this.status = status;
    }

//    public Long getAccountId() {
//        return accountId;
//    }

//    public void setAccountId(Long accountId) {
//        this.accountId = accountId;
//    }

    public Product_ProductType getCompositekey() {
        return compositekey;
    }

    public void setCompositekey(Product_ProductType compositekey) {
        this.compositekey = compositekey;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public ProductType getProductType() {
//        return productType;
//    }
//
//    public void setProductType(ProductType productType) {
//        this.productType = productType;
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
//                "accountId=" + accountId +
                ", created=" + created +
                ", customer=" + customer +
//                ", productType=" + productType +
                '}';
    }
}
