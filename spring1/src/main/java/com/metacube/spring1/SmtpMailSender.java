package com.metacube.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender implements MailSender {

	private String msg = "This is SMTP Mail";

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


}
