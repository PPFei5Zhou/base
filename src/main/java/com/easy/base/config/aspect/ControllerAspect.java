package com.easy.base.config.aspect;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Order(99)
@Component
public class ControllerAspect {
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private HttpServletRequest request;

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.info(throwable.getMessage());
        }
        return object;
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) { }

    @Pointcut("execution(* com.easy.base.controller.*.*(..))")
    public void pointcut() {
    }

    @After("pointcut()")
    public void after() {
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String url = request.getRequestURL().toString();
        String method = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()";
        log.info("Request url: " + url + ", method: " + method);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        try {
            String url = request.getRequestURL().toString();
            String method = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()";
            log.info("Request url: " + url + ", method: " + method + ", exception: " + throwable.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}