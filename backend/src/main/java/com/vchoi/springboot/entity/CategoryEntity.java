package com.vchoi.springboot.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
public class CategoryEntity extends BaseEntity {

    private String code;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products = new ArrayList<>();

    @Builder
    public CategoryEntity(long id, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String code, String name) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate);
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
