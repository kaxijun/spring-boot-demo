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

//    @CacheEvict：配置于函数上，通常用在删除方法上，用来从缓存中移除相应数据。除了同@Cacheable一样的参数之外，它还有下面两个参数：
//    allEntries：非必需，默认为false。当为true时，会移除所有数据
//    beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用方法之前移除数据。

}
