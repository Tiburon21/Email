package com.concretepage;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMailwithAttachment {
	public static void main(String[] args) throws MessagingException {
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	       ctx.register(AppConfig.class);
	       ctx.refresh();
	       JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
		   MimeMessage mimeMessage = mailSender.createMimeMessage();
		   //Pass true flag for multipart message
      	   MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
      	   mailMsg.setFrom("centrodiamondg@gmail.com");
      	   mailMsg.setTo("macsergio21@gmail.com");
      	   mailMsg.setSubject("Test mail with Attachment");
      	   mailMsg.setText("Please find Attachment.");
      	   //FileSystemResource object for Attachment
      	   FileSystemResource file = new FileSystemResource(new File("C:/Users/Serch/Documents/img/BB8.jpg"));
      	   mailMsg.addAttachment("mybb8.jpg", file);
	       mailSender.send(mimeMessage);
	       System.out.println("---Done---");
	}
}
