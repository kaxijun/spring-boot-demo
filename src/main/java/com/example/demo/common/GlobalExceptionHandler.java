package com.example.demo.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        RspBody<String> r = new RspBody<String>();
        r.setMessage(e.getMessage());
        r.setUrl(req.getRequestURL().toString());
        r.setData(null);
        r.setCode(RspBody.ERROR);
        return r;
    }
}

// 指向所有带有注解@RestController的控制器
//@ControllerAdvice(annotations = RestController.class)

// 指向所有指定包中的控制器
//@ControllerAdvice("org.example.controllers")
