package nl.paisanrietbroek.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */
@Aspect
@Component
public class LoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* nl.paisanrietbroek.API.*.*(..))")
    private void forAPIPackage() {}

    @Pointcut("execution(* nl.paisanrietbroek.Service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* nl.paisanrietbroek.DAO.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forAPIPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>> @Before: calling method: " + method);

        // display the arguments to the method
        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            logger.info("===>> argument: " + tempArg);
        }

    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("===>> @AfterReturning: from method: " + method);

        logger.info("===>> result: " + result);
    }

}
