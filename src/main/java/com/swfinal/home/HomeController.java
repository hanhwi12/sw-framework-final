package com.swfinal.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {
	@GetMapping("/home")
	public String home() {
		log.info("메인페이지 요청");
		return "Hello, SW Framework!";
	}
	
}
