package com.example.travel.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.travel.Application;
import com.example.travel.entity.User;

@Component
public class SignupEventPublisher {
private final ApplicationEventPublisher applicationEventPublisher;
public SignupEventPublisher(ApplicationEventPublisher applicationEventPublisher, Application application) {
	this.applicationEventPublisher = applicationEventPublisher;
}
public void publishSignupEvent(User user, String requestUrl) {
applicationEventPublisher.publishEvent(new SignupEvent(this, user, requestUrl));
}

}