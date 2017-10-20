package com.example.demo.controller;

import com.example.demo.pojo.Person;
import com.example.demo.common.RspBody;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private Person person;

    @Autowired
    private PersonService personService;

    /**
     * hello world
     * @param req
     * @return
     */
    @RequestMapping("/hello")
    public Object hello(HttpServletRequest req){
        return getRspBody(req ,"hello " + person.getName());
    }

    /**
     * hello mybatis && 错误处理
     * @param req
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByName")
    public Object findByName(HttpServletRequest req, Long id) throws Exception {
        if(null == id) throw new Exception("id is required");
        Person u = personService.findById(id);
        return getRspBody(req, u);
    }

    /**
     * insert pojo
     * @param req
     * @param age
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/insert")
    public Object insert(HttpServletRequest req, Integer age, String name) throws Exception {
        if(null == age || null == name) throw new Exception("params is required");
        personService.insertPerson(name, age);
        return getRspBody(req, "ok");
    }


    private <T> RspBody<T> getRspBody(HttpServletRequest req, T data) {
        RspBody<T> r = new RspBody<>();
        r.setMessage("ok");
        r.setUrl(req.getRequestURL().toString());
        r.setData(data);
        r.setCode(RspBody.OK);
        return r;

    }
}