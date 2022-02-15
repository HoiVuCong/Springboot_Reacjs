package com.vchoi.springboot.service.impl;

import com.vchoi.springboot.entity.ERole;
import com.vchoi.springboot.entity.Role;
import com.vchoi.springboot.entity.User;
import com.vchoi.springboot.repository.RoleRepository;
import com.vchoi.springboot.repository.UserRepository;
import com.vchoi.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Save new user {} to data base", user.getUserName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Save new role {} to data base", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addUserToRole(String userName, ERole roleName) {
        log.info("Adding  role {} to user {}", roleName.name(), userName);
        User user = userRepository.findUserByUserName(userName);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {} ", userName);
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public List<User> getAllUser() {
        log.info("Fetching all user");
        return userRepository.findAll();
    }
}
