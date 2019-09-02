/*
 * Copyright (c) 2019, wenwenliuyun@163.com All Rights Reserved. 
 */

package com.liuyun.aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author liuyun
 * @since 2019年9月1日下午9:02:58
 */
@Component
public class MyAopAdvice {
	public void before() {
		System.out.println("...before方法");
	}

	public void afterReturning() {
		System.out.println("...afterReturning方法");
	}

	public void afterThrowing() {
		System.out.println("...afterThrowing方法");
	}

	public void after() {
		System.out.println("...after方法");
	}

	/**
	 * around方式可以实现其他四种方式：before、afterReturning、afterThrowing、after
	 */
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object resutlValue = null;
		try {
			System.out.println("around......before方法");
			resutlValue = pjp.proceed();// 调用被代理的方法
			System.out.println("around......afterReturning方法");
		} catch (Throwable e) {
			System.out.println("around......afterThrowing方法");
			throw e;
		} finally {
			System.out.println("around......after方法");
		}
		return resutlValue;
	}
}
