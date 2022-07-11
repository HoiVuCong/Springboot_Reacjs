package com.vchoi.springboot.controller;

import com.vchoi.springboot.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
public class AuthorController {

    private static String userName = "hoivc";
    private static String passWord = "abc";

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("user") String name, @RequestParam("pass") String pass) {
        if (name.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(passWord)) {
            return ResponseEntity.ok(jwtTokenProvider.generateToken());
        } else {

            return new ResponseEntity<>("sai account", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/callRequest")
    public ResponseEntity<String> callRequest() {
        return ResponseEntity.ok("OKE");

    }
}
