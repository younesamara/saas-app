package com.younes.saas.domain.models;

import java.time.LocalDate;

public class StockMvt {

    private String id;
    private TypeMvt typeMvt;
    private Integer quantity;
    private LocalDate dateMvt;
    private String comment;
    private String productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TypeMvt getTypeMvt() {
        return typeMvt;
    }

    public void setTypeMvt(TypeMvt typeMvt) {
        this.typeMvt = typeMvt;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateMvt() {
        return dateMvt;
    }

    public void setDateMvt(LocalDate dateMvt) {
        this.dateMvt = dateMvt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
