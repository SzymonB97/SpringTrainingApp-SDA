package com.allegro.trade.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IndexAOP {

    private Logger logger = LoggerFactory.getLogger(IndexAOP.class);

    @After("execution(* com.allegro.trade.controllers.IndexController.index(..))")
    public void visitMainPage(JoinPoint joinPoint) {
        logger.info("Someone enters main page");
    }
}
