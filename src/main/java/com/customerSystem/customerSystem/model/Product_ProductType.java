package com.customerSystem.customerSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Product_ProductType implements Serializable {

    @Column(name = "account")
    private Long account_id;
    @Column(name = "product_type_id")
    private Long product_type_id;

    public Product_ProductType(Long account_id, Long productType) {
        this.account_id = account_id;
//        this.productType = productType;
        this.product_type_id = productType;
    }

    public Product_ProductType() {
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Long getProductType() {
        return product_type_id;
    }

    public void setProductType(Long productType) {
        this.product_type_id = productType;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Product_ProductType that = (Product_ProductType) o;

        if(!Objects.equals(account_id, that.account_id)) return false;
        return Objects.equals(product_type_id, that.product_type_id);
    }

    @Override
    public int hashCode() {
        int result = account_id != null ? account_id.hashCode() : 0;
        result = 31 * result + (product_type_id != null ? product_type_id.hashCode() : 0);
        return  result;
    }
}
