package io.priyospace.springbootthymleaf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    private static final Logger log= LoggerFactory.getLogger("HelloController.class");

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name, Model model){
        String requestName=name;
        if(name.equals(null)){
            requestName="Strager!";
        }
        String  displayMessage="hello...."+requestName;
        log.info("name captured as {}",displayMessage);
        model.addAttribute("message",displayMessage);
        return "hello";
    }
}
