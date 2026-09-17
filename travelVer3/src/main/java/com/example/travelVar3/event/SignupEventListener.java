package com.example.travelVar3.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.travelVar3.entity.User;
import com.example.travelVar3.service.VerificationTokenService;

@Component
public class SignupEventListener {
private final VerificationTokenService  verificationTokenService;
private final JavaMailSender javaMailSender;
public SignupEventListener(VerificationTokenService  verificationTokenService,JavaMailSender MailSender) {
	this.javaMailSender=MailSender;
	this.verificationTokenService=verificationTokenService;
	
}
@EventListener
private void onSigunupEvent(SignupEvent signupEvent) {
	User user=signupEvent.getUser();
	String token=UUID.randomUUID().toString();
	verificationTokenService.create(user, token);
	String recipientAddress=user.getEmail();
	String subject="メール認証";
	String confirmationUrl=signupEvent.getRquestUrl()+"/verify?token="+token;
	String message="以下のリンクをクリックして会員登録を完了させてください";
	SimpleMailMessage mailMessage = new SimpleMailMessage();
	mailMessage.setTo(recipientAddress);
	mailMessage.setSubject(subject);
	mailMessage.setText(message+"\n"+confirmationUrl);
	javaMailSender.send(mailMessage);

}
}
