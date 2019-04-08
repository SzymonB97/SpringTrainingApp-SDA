package com.allegro.trade.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ProductAOP {

    private Logger logger = LoggerFactory.getLogger(ProductAOP.class);

    //koniecznie spacja po*, * oznacza zwracany typ (w tym przypadku wszystkie), można zamiast niej wprowadzić konkretny
    @Before("execution(* com.allegro.trade.services.impl.ProductServiceImpl.deleteProduct(..))")
    public void beforeDeleteProduct(JoinPoint joinPoint) {
        logger.info("ProductServiceImpl.deleteProduct() : " + joinPoint.getSignature().getName());
        Arrays.stream(joinPoint.getArgs()).forEach(arg -> logger.debug(arg.toString()));
    }
}
