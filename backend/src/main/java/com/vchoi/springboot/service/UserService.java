package com.vchoi.springboot.service;

import com.vchoi.springboot.entity.ERole;
import com.vchoi.springboot.entity.Role;
import com.vchoi.springboot.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addUserToRole(String userName, ERole role);

    User getUser(String userName);

    List<User> getAllUser();

}
