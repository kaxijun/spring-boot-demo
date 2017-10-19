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
public class Person {
    @Getter
    @Setter
    @Value("${prop.name}")
    private String name;
}