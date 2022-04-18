package com.vchoi.springboot.service;

import com.vchoi.springboot.dto.UserDTO;
import com.vchoi.springboot.entity.ERole;
import com.vchoi.springboot.entity.Role;
import com.vchoi.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, ERole role);

    User getUser(String userName);

    List<User> getAllUser();

}
