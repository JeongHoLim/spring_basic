package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns="/*")
public class PerformanceFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
//		1. ��ó��
		long startTime = System.currentTimeMillis();
		
//		2. ���� Ȥ�� ���� ���� ȣ��
		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest)request;
		String referer = req.getHeader("referer");
		String method = req.getMethod();
		
//		3. ��ó�� �۾�
		
		System.out.printf("["+ referer + "] -> "+  method + "[" + req.getRequestURI() + "]");
		System.out.println("�ҿ� �ð� : " + (System.currentTimeMillis()-startTime) + "ms");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
