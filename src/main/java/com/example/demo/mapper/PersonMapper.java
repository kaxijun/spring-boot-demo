package com.example.demo.mapper;

import com.example.demo.pojo.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@Mapper
//@CacheConfig(cacheNames = "personMapper")
public interface PersonMapper {

    @Select("SELECT * FROM PERSON WHERE ID = #{id}")
//    @Cacheable()
    // @Cacheable(key = "#p0", condition = "#p0.length() < 3")
    Person findById(@Param("id") Long id);
//    @CachePut
    @Insert("INSERT INTO PERSON(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM PERSON WHERE ID = #{id}")
//    @CacheEvict
    void delete(@Param("id") Long id);

//    @CacheEvict：配置于函数上，通常用在删除方法上，用来从缓存中移除相应数据。除了同@Cacheable一样的参数之外，它还有下面两个参数：
//    allEntries：非必需，默认为false。当为true时，会移除所有数据
//    beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用方法之前移除数据。

}
