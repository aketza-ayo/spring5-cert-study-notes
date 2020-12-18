package org.spring.cert.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.spring.cert.annotations.Sanitize;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Aspect
@Component
public class SanitizeAspect {

    @Around("execution(* org..beans.*.*(*, ..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        return proceedingJoinPoint.proceed(
                sanitizeArgumentsIfRequired(
                        proceedingJoinPoint.getArgs(),
                        methodSignature
                )
        );
    }

    private Object[] sanitizeArgumentsIfRequired(Object[] args, MethodSignature methodSignature){
        Object[] filteredArgs = new Object[args.length];
        for(int i = 0; i < args.length; i++){
            filteredArgs[i] = sanitizeArgumentIfRequired(
                    args[i],
                    methodSignature.getMethod().getParameterAnnotations()[i]
            );
        }

        return filteredArgs;

    }

    private Object sanitizeArgumentIfRequired(Object arg, Annotation[] parameterAnnotation){
        if(containsAnnotationOfType(parameterAnnotation, Sanitize.class) && arg.getClass() == String.class){
            return "***sanitized***";
        }else{
            return arg;
        }
    }

    private boolean containsAnnotationOfType(Annotation[] parameterAnnotations, Class sanitizeClass){
        return Arrays.stream(parameterAnnotations)
                .map(Annotation::annotationType)
                .anyMatch(sanitizeClass::equals);
    }
}
