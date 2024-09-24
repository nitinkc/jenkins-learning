package com.learn.devops;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String health(){
        String url = "http://localhost:9000/profile";
        return "Healthy and running" +"\n"+ url;
    }


}
