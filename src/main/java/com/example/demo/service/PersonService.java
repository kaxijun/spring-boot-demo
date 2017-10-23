package com.example.demo.service;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public Person findById(Long id) {
        return personMapper.findById(id);
    }

    public void insertPerson(String name, int age) {
        personMapper.insert(name, age);
    }

}
