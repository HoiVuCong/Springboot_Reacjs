package com.vchoi.springboot.controller;

import com.vchoi.springboot.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private static String userName = "hoivc";
    private static String passWord = "abc";
    private static String fixJWT = "jwt";

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user") String name, @RequestParam("pass") String pass) {
        if(name.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(passWord)) {
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
            return  ResponseEntity.ok(jwtTokenProvider.generateToken());
        }else {

            return new ResponseEntity("sai account", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/callRequest")
    public ResponseEntity<String> callRequest(@RequestBody String jwtRequest) {

              return ResponseEntity.ok("OKE");

    }
}
