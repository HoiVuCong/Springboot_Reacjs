package com.vchoi.springboot.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String fullName;
    private Date birthday;
    private String email;
    private String password;
    private int phoneNumber;
    private String gender;
    private String Role;

}
