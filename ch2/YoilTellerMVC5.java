package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC5 {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace(); 
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC5")
	public String main(@ModelAttribute MyDate date,Model model) {
		
		if(!isValid(date)) {
			return "yoilError";
		}
		  
//		char yoil = getYoil(date);
		
//		model.addAttribute("myDate",date);
//		model.addAttribute("yoil",yoil);
		
		return "yoil";
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(),date.getMonth(),date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(),date.getMonth(),date.getDay());
	}

	private char getYoil(int year, int month, int day) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
	
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
