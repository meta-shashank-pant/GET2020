package com.metacube.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Spring1Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
		MailSender sender = (MailSender) context.getBean(MailSender.class);
		
		sender.send();
	}

}
