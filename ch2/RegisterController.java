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
//	@RequestMapping("/register/add")	//�ű� ȸ�� ����
//	@GetMapping("/add")
	public String register() {
		return "registerForm";
	}
	
	//servlet-context.xml�� view-controller�� ��� ( GET�� ��� )
	
//	@RequestMapping(value ="/register/save",method=RequestMethod.POST)
	@PostMapping("/save")   //spring 4.3���� ����
	// ��ΰ� ������ �浹������, �޼���(get,post)�� �ٸ��� �������� 
	public String save(User user,Model m) throws Exception{
		
//		1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.","utf-8");
			
			m.addAttribute("msg",msg);
			return "forward:/register/add";
			//redirect�� ���û�� �ǹ�, ������ save()���� ����ϴ� ���� /add�� �ѱ� �� ����. 
			//�������� �Ʒ�ó�� �ڵ����� ��ȯ����
//			return "redirect:/register/add?msg="+msg;		//URL ���ۼ�(rewriting)
		}
//		2. DB�� �ű� ȸ�� ���� ����
		
		return "registerInfo";
	}
	
	private boolean isValid(User user) {
	// TODO Auto-generated method stub

		return false;
	}

	
}
