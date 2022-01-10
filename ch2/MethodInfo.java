package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {

	public static void main(String[] args) throws Exception{

//		1. yoilTellerMVC 클래스 객체 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName();
			Parameter[] paramArr = m.getParameters();
			
			Class returnType = m.getReturnType();
			
			StringJoiner paramList = new StringJoiner(", ","(",")");
			
			for(Parameter p : paramArr) {
				String paramName = p.getName();
				Class paramType = p.getType();
				
				paramList.add(paramType + " " + paramName);
				
			}
			System.out.printf("%s %s %s\n",returnType.getName(),name,paramList);
		}
		
		
	}

}
