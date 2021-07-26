package com.vchoi.springboot.controller;


import com.vchoi.springboot.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {

//    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
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
