package com.example.demo.mapper;

import com.example.demo.pojo.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM PERSON WHERE ID = #{id}")
    Person findById(@Param("id") Long id);
    @Insert("INSERT INTO PERSON(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
