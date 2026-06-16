package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	

	public void sendEmail(String from, String[] to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
		
		helper.setTo(to);
		helper.setFrom(from);
		helper.setSubject(subject);
		helper.setText(body,true);
		mailSender.send(message);
        System.out.println(" Email sent to " + to.length + " recipients!");

		}catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
