package com.example.demo.common;

import lombok.Getter;
import lombok.Setter;

public class RspBody<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private T data;

}