package com.example.demo.mapper;

import com.example.demo.pojo.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM PERSON WHERE ID = #{id}")
    Person findById(@Param("id") Long id);
    @Insert("INSERT INTO PERSON(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM PERSON WHERE ID = #{id}")
    void delete(@Param("id") Long id);


}
