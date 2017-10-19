package com.example.demo.common;

import com.example.demo.pojo.RspBody;
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
        r.setData("some data");
        r.setCode(RspBody.ERROR);
        return r;
    }
}