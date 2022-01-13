package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/login")
	public String loginForm() {
		
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		1. 세션 종료
		session.invalidate();
//		2. 홈으로 이동
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(String id,String pwd,String toURL,boolean rememberId,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
//		1. id와 pwd 확인
		if(!loginCheck(id,pwd)) {
//			2-1. 일치하지 않으면. loginForm으로 이동

			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.","utf-8");
			return "redirect:/login/login?msg="+msg;
		}

//			2-2. id와 pwd가 일치하는 경우
		// 세션 객체 얻어 오기
		HttpSession session = request.getSession();
//		세션 객체에 id를 저장
		session.setAttribute("id",id);
		Cookie cookie = new Cookie("id",id);
		if(rememberId) {

//			1. 쿠키를 생성
//			Cookie cookie = new Cookie("id",id);
//			2. 응답에 저장
//			response.addCookie(cookie);
				
		}
		else {
//			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);
//			response.addCookie(cookie);
		} 		
		response.addCookie(cookie);
//		3. 홈으로 이동
		System.out.println("before : " + toURL + toURL.equals(" "));
		
		toURL = (toURL == null || toURL.equals(" ")) ? "/" : toURL; 
		System.out.println("after : " + toURL + toURL.length());
		
		return "redirect:"+toURL;
	}
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
		//순서 바꾸는 이유 -> null 검사할 필요 없어서 
	}
}
