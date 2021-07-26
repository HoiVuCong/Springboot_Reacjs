package com.vchoi.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity{

        private String code;
        private String name;

        @ManyToMany(mappedBy = "roles")
        private List<User> users = new ArrayList<>();
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

        public List<User> getUsers() {
                return users;
        }

        public void setUsers(List<User> users) {
                this.users = users;
        }
}
