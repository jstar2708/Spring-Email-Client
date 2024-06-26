package com.jaideep.ses;

import com.jaideep.ses.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailClientApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailSenderService.sendSimpleMail(
				"temporary27082002@gmail.com",
				"This is email body",
				"This is email subject"
		);
		emailSenderService.sendEmailWithAttachment(
				"temporary27082002@gmail.com",
				"This is email body",
				"This is email subject",
				"C:\\Users\\jaideep.s.singh\\Downloads\\acisensa.log"
		);
	}



}
