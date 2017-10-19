package com.example.demo.controller;

import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("web")
public class TemplateController {

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello(ModelMap map){
        map.addAttribute("name", person.getName());
        return "hello";
    }

    @RequestMapping("/error")
    public String error(ModelMap map) throws Exception {
        throw new Exception("exception");
    }
}