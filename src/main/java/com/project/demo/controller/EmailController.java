package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping("/send")
	public String sendEmail(@RequestParam String from,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
		 emailService.sendSimpleEmail( from, to, subject, body   );
	        return "Email sent to " + to;
	}
	
}
