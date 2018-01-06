package main.com.demo.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by f.kusztelak@gmail.com on 2018-01-06.
 */
@Aspect
@Component
public class CRMLoggingAspect {

    private static final Logger LOGGER =
            Logger.getLogger(CRMLoggingAspect.class.getName());

    // setup pointcut declarations
    @Pointcut("execution(* main.com.demo.spring.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* main.com.demo.spring.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* main.com.demo.spring.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // display the method that is called
        String theMethod = theJoinPoint.getSignature().toShortString();
        LOGGER.info("======> in @Before: calling method: " + theMethod);

        // display the arguments of the method
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            LOGGER.info("======> argument: " + tempArg);
        }
    }

    // add AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display method and data returned
        String theMethod = theJoinPoint.getSignature().toShortString();
        LOGGER.info("======> in @AfterReturning: from method: " + theMethod);

        LOGGER.info("======> result: " + theResult);
    }
}
