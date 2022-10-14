package com.springrest.springrest.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggerAdvice 
{
	Logger log = LoggerFactory.getLogger(LoggerAdvice.class);
	
	@Pointcut(value="execution(* com.springrest.springrest.*.*.*(..))")
	public void myPointCut()
	{		
	}
	
	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable
	{
		ObjectMapper mapper =  new ObjectMapper();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().toString();
		Object[] array = joinPoint.getArgs();
		
		log.info("Method Invoked from :  "+className+ " : "+ methodName +"()"+"arguments : "
				+ mapper.writeValueAsString(array));
				Object object = joinPoint.proceed();
		log.info(className+ " : "+ methodName +"()"+"Response : "
				+ mapper.writeValueAsString(object));
		System.out.println("---------------------------------------------------------------------------------------------------------");

		return object;
	}
}
