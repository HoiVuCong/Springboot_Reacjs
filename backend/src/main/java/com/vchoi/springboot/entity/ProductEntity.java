package com.vchoi.springboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends BaseEntity {

    private String title;
    private String thumbnail;
    private String shortDescription;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Builder
    public ProductEntity(long id, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String title, String thumbnail, String shortDescription, String content) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate);
        this.title = title;
        this.thumbnail = thumbnail;
        this.shortDescription = shortDescription;
        this.content = content;
    }
}
