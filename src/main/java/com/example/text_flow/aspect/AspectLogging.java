package com.example.text_flow.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

    static final Logger logger = LoggerFactory.getLogger(AspectLogging.class);

    @Around("execution(* com.example.text_flow.*.*.*(..))")
    public Object aroundAllMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String message = " of " + methodSignature.getDeclaringTypeName() + "."
                + methodSignature.getName()
                + "("+ getMethodParams(proceedingJoinPoint) + ");";

        logger.info("START" + message);

        Object result = proceedingJoinPoint.proceed();

        logger.info("FINISH" + message + " RETURN RESULT = " +  result);

        return result;
    }

    private String getMethodParams(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        Object[] args = proceedingJoinPoint.getArgs();
        String[] parametersName = methodSignature.getParameterNames();
        StringBuilder sbParams = new StringBuilder();

        for(int i = 0; i < args.length; i++){
            sbParams.append(parametersName[i]).append(" = ").append(args[i]);
            if(i != args.length - 1){
                sbParams.append(", ");
            }
        }

        return sbParams.toString();
    }

}
