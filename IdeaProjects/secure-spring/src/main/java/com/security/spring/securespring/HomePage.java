package com.security.spring.securespring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {

    @GetMapping("/")
    public String greetMember(){
        return "<h1>HI There, Welcome!</h1>";
    }

    @GetMapping("/user")
    public String greetUser(){
        return "<h1>HI User, Welcome!</h1>";
    }

    @GetMapping("/admin")
    public String greetAdmin(){
        return "<h1>HI Admin, Welcome!</h1>";
    }
}
