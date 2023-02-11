package com.pos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @GetMapping(path = "/get-my-test")
    public void getMyText(){
        String myTest = "Hello Spring boot";
        System.out.println(myTest);
    }

    @GetMapping(path = "/get-my-test-1")
    public String getMyText1(){
        String myTest1 = "Hello Spring boot 1 ";
        return myTest1;
    }
}
