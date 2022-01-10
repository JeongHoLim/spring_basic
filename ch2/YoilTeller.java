package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {

	@RequestMapping("/getYoil")
	public void main(int year,int month,int day,HttpServletResponse response) throws IOException {
		
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = "일월화수목금토".charAt(dayOfWeek);
		
	
		response.setContentType("text/html");
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println(year +"년 " + month +"월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
		
	}
	
}
