package com.vchoi.springboot.dto;

import com.vchoi.springboot.entity.Role;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String fullName;
    private Date birthday;
    private String email;
    private String password;
    private int phoneNumber;
    private String gender;
    private List<Role> roles;

}
