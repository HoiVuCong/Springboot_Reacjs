package com.vchoi.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

        private String code;
        private ERole name;

        @ManyToMany(mappedBy = "roles")
        private List<User> users = new ArrayList<>();

}
