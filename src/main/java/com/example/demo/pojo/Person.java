package com.example.demo.pojo;


import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by lzw on 2017/10/17.
 */
@Component
@Data  //包括了 @ToString, @EqualsAndHashCode @Getter  @Setter
@Log4j
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    @Value("${prop.name}")
    private String name;

    private Integer age;


}
