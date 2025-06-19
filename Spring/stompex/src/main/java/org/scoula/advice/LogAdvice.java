package org.scoula.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Log4j2
@Component
public class LogAdvice {

	// Pointcut 표현식으로 JoinPoint 결정
	@Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("======================");
	}

	@Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String,String))&&args(str1,str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1: " + str1);
		log.info("str2: " + str2);
	}

	// 예외가 발생했을 때에만 실행됨
	@AfterThrowing(pointcut = "execution(* org.scoula.sample.service.SampleService*.*(..))", throwing = "exception")
	public void logException(Exception exception) {
		log.info("Exception !!!!!");
		log.info("exception: " + exception);
	}

	// 성능 모니터링
	@Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis(); // 호출 전 시간

		log.info("Target: " + pjp.getTarget()); // 객체 확인
		log.info("Param: " + Arrays.toString(pjp.getArgs())); // 매개변수 확인

		Object result = null;
		try {
			result = pjp.proceed(); // 실제 메서드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis(); // 호출 후 시간

		log.info("TIME: " + (end - start));

		return result;

	}
}
