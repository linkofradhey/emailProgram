package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.EmailDto.EmailDtoo;
import com.project.demo.service.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "*") 
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping("/send")
	public String sendEmail(@RequestBody EmailDtoo req) {
		 emailService.sendEmail(
				 	req.getFrom(),
			        req.getTo().toArray(new String[0]),  // Convert List to String[]
			        req.getSubject(),
			        req.getBody()
			    );
			    return "Email sent to " + req.getTo().size() + " recipients!";

	}
	
}
