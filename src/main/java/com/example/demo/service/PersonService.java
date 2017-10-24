package com.example.demo.service;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "personMapper")
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Cacheable
    public Person findById(Long id) {
        System.out.println("查询数据库:" + id);
        return personMapper.findById(id);
    }
    @CachePut
    public void insertPerson(String name, int age) {
        personMapper.insert(name, age);
    }
    @CacheEvict
    public void deletePerson(Long id) {
        System.out.println("从缓存中删除");
        personMapper.delete(id);
    }

}
