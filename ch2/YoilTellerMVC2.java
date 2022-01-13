package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC2 {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace(); 
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
	public String main(@RequestParam(required=true) int year,
			@RequestParam(required=true) int month,
			@RequestParam(required=true) int day,Model model) {
		
		if(!isValid(year,month,day)) {
			return "yoilError";
		}
		  
		
		char yoil = getYoil(year,month,day);
		
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		return "yoil";
	}

	private char getYoil(int year, int month, int day) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		char yoil = "일월화수목금토".charAt(dayOfWeek);
		
		
		return yoil;
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		
		if(month<1 || month > 12) return false;
		if(year < 0) return false;
		if(day < 1 || day > 31) return false;
		
		return true;
	}
}
