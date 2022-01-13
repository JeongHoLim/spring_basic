package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@RequestMapping(value = "/add",method= {RequestMethod.POST,RequestMethod.GET})
//	@RequestMapping("/register/add")	//신규 회원 가입
//	@GetMapping("/add")
	public String register() {
		return "registerForm";
	}
	
	//servlet-context.xml에 view-controller로 등록 ( GET만 허용 )
	
//	@RequestMapping(value ="/register/save",method=RequestMethod.POST)
	@PostMapping("/save")   //spring 4.3부터 지원
	// 경로가 같으면 충돌나지만, 메서드(get,post)가 다르면 문제없음 
	public String save(User user,Model m) throws Exception{
		
//		1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
			
			m.addAttribute("msg",msg);
			return "forward:/register/add";
			//redirect는 재요청의 의미, 원래는 save()에서 사용하는 모델은 /add로 넘길 수 없다. 
			//스프링이 아래처럼 자동으로 변환해줌
//			return "redirect:/register/add?msg="+msg;		//URL 재작성(rewriting)
		}
//		2. DB에 신규 회원 정보 저장
		
		return "registerInfo";
	}
	
	private boolean isValid(User user) {
	// TODO Auto-generated method stub

		return false;
	}

	
}
