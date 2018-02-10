package com.labratorij.gameshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }
}
