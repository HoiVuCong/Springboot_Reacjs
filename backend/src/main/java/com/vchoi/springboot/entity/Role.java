package com.vchoi.springboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity {

        private String code;
        private ERole name;

        @ManyToMany(mappedBy = "roles")
        private List<User> users = new ArrayList<>();

        public Role(long id, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String code, ERole name) {
                super(id, createdBy, createdDate, modifiedBy, modifiedDate);
                this.code = code;
                this.name = name;
        }
}
