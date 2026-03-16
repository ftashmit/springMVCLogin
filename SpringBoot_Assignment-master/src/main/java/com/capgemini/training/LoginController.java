package com.capgemini.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	LoginServices loginServices;
	@Autowired
	UserEntity userEntity;
	
	
	@GetMapping("/")
	public String loginPage() {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String validate(String user, String password) {
		System.out.println(user);
		System.out.println(password);
		if(user.isEmpty()||password.isEmpty())
			return "login.jsp";
		return "home.jsp";
	}
	
	@PostMapping("/register")
	public String register(HttpServletRequest request){
		
		String empId = request.getParameter("empId");
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		System.out.println("Emp Id : "+empId);
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		System.out.println("Password : "+password);
		
		
		userEntity.setName(name);
		userEntity.setUser(user);
		userEntity.setEmail(email);
		userEntity.setPassword(password);
		
		
		
		return "home.jsp";
		
	}
	
	
}