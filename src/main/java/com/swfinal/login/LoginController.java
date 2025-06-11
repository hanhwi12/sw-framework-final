package com.swfinal.login;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/rest")
public class LoginController {
	LoginService loginService;
		public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
		
	@GetMapping("login")
	public String login() {
		log.info("로그인 페이지 요청");
		return "login";
	}
	
	
	@PostMapping(value = "/request-login", produces = "application/json")
	@ResponseBody
	public Map<String, Object> requestLogin(@RequestBody Map<String, Object> param, HttpSession session) {
		log.info("login 정보 : {}", param);
		Map<String, Object> result = loginService.requestLogin(param);
		
		if("0000".equals((String) result.get("REPL_CD"))) {
			session.setAttribute("userId", param.get("userPw"));
		}
		return result;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃 요청");
		session.invalidate();
	}
	
	
	
	
	
	
}
	