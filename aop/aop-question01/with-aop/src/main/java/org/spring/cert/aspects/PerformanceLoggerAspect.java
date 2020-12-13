package org.spring.cert.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

@Aspect
@Component
public class PerformanceLoggerAspect {

    private Logger logger = Logger.getLogger("performance.logger");

    @Around("@annotation(org.spring.cert.annotations.PerformanceLogger)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        long startTime = System.currentTimeMillis();
        try{
            return proceedingJoinPoint.proceed();
        }finally{
            long finishtime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishtime - startTime);

            logger.info(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature(), duration));
        }

    }

}
