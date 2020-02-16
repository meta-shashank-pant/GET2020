package com.metacube.spring1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MockMailSender implements MailSender {

	@Value("This is Mock Mail")
	private String msg;
	
	@Autowired
	@Qualifier("smtpMailSender")
	private MailSender myMail;
	
	
	/**
	 * Constructor injection using @Autowired annotation.
	 */
//	@Autowired
//	public MockMailSender(MailSender myMail) {
//		this.myMail = myMail;
//	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println(msg);
		myMail.send();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



}
