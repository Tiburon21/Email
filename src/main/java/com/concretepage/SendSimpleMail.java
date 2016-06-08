package com.concretepage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendSimpleMail {
	public static void main(String[] args) throws MessagingException {
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	       ctx.register(AppConfig.class);
	       ctx.refresh();
	       JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
		   MimeMessage mimeMessage = mailSender.createMimeMessage();
      	   MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
      	   mailMsg.setFrom("centrodiamondg@gmail.com");
      	   mailMsg.setTo("macsergio21@gmail.com");
      	   mailMsg.setSubject("Test mail");
      	   mailMsg.setText("Hello SEÑO!");
	       mailSender.send(mimeMessage);
	       System.out.println("---Done---");
	}
}
