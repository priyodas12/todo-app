package com.springjdbc.authenticationwithjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome Home!</h1>");
    }

    @GetMapping("/user")
    public String homeOfUser(){
        return ("<h1>Welcome Home, User!</h1>");
    }

    @GetMapping("/admin")
    public String homeOfAdmin(){
        return ("<h1>Welcome Home, Admin!</h1>");
    }
}
