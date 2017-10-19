package com.example.demo.controller;

import com.example.demo.pojo.Person;
import com.example.demo.pojo.RspBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class HelloSpringBoot{

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public Object hello(HttpServletRequest req){
        RspBody<String> r = new RspBody<String>();
        r.setMessage("ok");
        r.setUrl(req.getRequestURL().toString());
        r.setData("hello " + person.getName());
        r.setCode(RspBody.OK);
        return r;
    }
}