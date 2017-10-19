package com.example.demo.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lzw on 2017/10/17.
 */
@Component
@Data
@Log4j
@Getter
@Setter
public class Person {

    private long id;

    @Value("${prop.name}")
    private String name;

    private int age;


}
