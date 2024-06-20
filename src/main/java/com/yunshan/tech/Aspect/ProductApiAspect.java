package com.yunshan.tech.Aspect;

import com.yunshan.tech.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
public class ProductApiAspect {
    @Resource
    private UserService userService;

    @Before("execution(* com.yunshan.tech.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void checkToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/product")) {
            String token = request.getHeader("Authorization");

            if (token == null || !userService.isValidToken(token)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid or missing token");
            }
        }
    }
}
