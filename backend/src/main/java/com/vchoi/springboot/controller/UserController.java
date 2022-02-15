package com.vchoi.springboot.controller;


import com.vchoi.springboot.dto.UserDTO;
import com.vchoi.springboot.entity.User;
import com.vchoi.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/addUser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @PutMapping(value = "/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @DeleteMapping(value = "/updateUser")
    public void deleteUser(@RequestBody long[] ids) {

    }
}
