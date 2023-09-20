package com.customersystem.customersystem.modeldto;

import java.util.Date;

public class ProductDto {
    private Long accoundId;
    private String productType;
    private Date created;
    private Long cin;
    private String status;

    public ProductDto() {
    }

    public ProductDto(Long accoundId, String productType, Date created, Long cin, String status) {
        this.accoundId = accoundId;
        this.productType = productType;
        this.created = created;
        this.cin = cin;
        this.status = status;
    }

    public Long getAccoundId() {
        return accoundId;
    }

    public void setAccoundId(Long accoundId) {
        this.accoundId = accoundId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
