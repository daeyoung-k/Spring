package com.team404.common.util.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.team404.controller.HomeController;

@Aspect //AOP를 적용시킬 클래스
@Component
public class LogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	
	//맨앞에 *는 접근제어자를 의미, 맨 뒤에 *는 메서드를 의미함
	
//	@Before("execution(* com.team404.controller.*Controller.*(..))")
//	@Before("execution(* com.team404.*.service.*ServiceImpl.*(..))")
//	public void beforeLog() {
//		System.out.println("메서드 실행전");
//	}
//	
//	@After("execution(* com.team404.*.service.*ServiceImpl.*(..))")
//	public void afterLog() {
//		System.out.println("메서드 실행이후");
//	}
	
	//에러가 발생했을 때 동작 (throwing = "e") - 에러를 처리할 변수
//	@AfterThrowing(pointcut = "execution(* com.team404.*.service.*ServiceImpl.*(..))", throwing = "e")
	public void errorLog(Exception e) {
		System.out.println("에러 로그:" + e);
	}
	
	//로그레벨추가 (log4j.xml)
	/*
	 <logger name="com.team404.common.util.aop">
		<level value="info" />
	 </logger>	
	 */
	//before, after, afterThrowing 세가지를 한번에 처리할 수 있게 해주는 Around
	//메서드 실행 권한을 가지고, 타겟메서드랑 접목시켜서 사용
	//규칙 - 반환은 Object, 매개변수로 메서드의 실행지점을 경정짓는 ProceedingJoinPoint를 선언합니다.	
	@Around("execution(* com.team404.*.service.*ServiceImpl.*(..))")
	public Object arroundLog(ProceedingJoinPoint jp) {
		
		long start = System.currentTimeMillis();
		
		logger.info("실행클래스:"+jp.getTarget());
		logger.info("실행메서드:"+jp.getSignature().toString());
		logger.info("매개값:"+ Arrays.toString(jp.getArgs()));
		
		Object result = null;
		try {			
			result = jp.proceed(); //타겟 메서드의 실행을 의미
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		logger.info("메서드 소요시간:" + (end - start) * 0.001);
		
		return result; //proceed()의 결과를 반환해야 메서드의 정상 흐름으로 돌아갑니다.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
