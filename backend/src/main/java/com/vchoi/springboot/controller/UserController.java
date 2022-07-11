package com.vchoi.springboot.controller;


import com.vchoi.springboot.dto.UserDTO;
import com.vchoi.springboot.entity.ERole;
import com.vchoi.springboot.entity.Role;
import com.vchoi.springboot.entity.User;
import com.vchoi.springboot.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @PostMapping(value = "/user/save")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userDTO));
    }

    @PostMapping(value = "/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping(value = "/role/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUserName(), form.getERole());
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = "/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @DeleteMapping(value = "/updateUser")
    public void deleteUser(@RequestBody long[] ids) {

    }
}
@Data
class RoleToUserForm {
    private String userName;
    private ERole eRole;
}
