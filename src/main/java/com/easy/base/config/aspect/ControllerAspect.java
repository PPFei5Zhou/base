package com.easy.base.config.aspect;

import javax.servlet.http.HttpServletRequest;

import com.easy.base.domain.dto.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(99)
@Component
public class ControllerAspect {
    private ObjectMapper objectMapper;
    private HttpServletRequest request;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public ControllerAspect(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
        this.objectMapper = objectMapper;
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.info(throwable.getMessage());
        }
        return object;
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        try {
            String url = request.getRequestURL().toString();
            String method = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()
                    + "()";
            logger.info("Request url: " + url + ", method: " + method);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

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
        if (result instanceof JsonResult) {
            JsonResult jsonResult = (JsonResult) result;
            try {
                logger.info("Request url: " + url + ", method: " + method + ", return: " + objectMapper.writeValueAsString(jsonResult));
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        try {
            String url = request.getRequestURL().toString();
            String method = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()";
            logger.info("Request url: " + url + ", method: " + method + ", exception: " + throwable.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}