package com.vchoi.springboot.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {

    private String userName;
    private String fullName;
    private Date birthday;
    private String email;
    private String password;
    private int phoneNumber;
    private String gender;

    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @Builder
    public User(long id, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate,
                String userName, String fullName, Date birthday, String email, String password,
                int phoneNumber, String gender, List<Role> roles) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate);
        this.userName = userName;
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.roles = roles;
    }
}
