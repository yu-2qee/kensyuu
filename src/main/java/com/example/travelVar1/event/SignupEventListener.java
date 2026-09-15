package com.example.travelVar1.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.travelVar1.entity.User;
import com.example.travelVar1.service.VerificationTokenService;

@Component
public class SignupEventListener {
private final VerificationTokenService verificationTokenService;
private final JavaMailSender javaMailSender;
public SignupEventListener(VerificationTokenService verificationTokenService,JavaMailSender mailSender) {
	this.verificationTokenService=verificationTokenService;
	this.javaMailSender=mailSender;
}
@EventListener
private void onSignupEvent(SignupEvent signupEvent) {
	User user=signupEvent.getUser();
	String Token=UUID.randomUUID().toString();
	verificationTokenService.create(user,Token);
	String recipientAddress=user.getEmail();
	String subject="メール認証";
	String confirmationUrl=signupEvent.getRequestUrl() + "/verify?token=" +Token;
	String message="以下のリンクをクリックして登録を完了させてください";
	SimpleMailMessage mailMessage=new SimpleMailMessage();
	mailMessage.setTo(recipientAddress);
	mailMessage.setSubject(subject);
	mailMessage.setText(message +"\n"+ confirmationUrl);
	javaMailSender.send(mailMessage);
}

}
