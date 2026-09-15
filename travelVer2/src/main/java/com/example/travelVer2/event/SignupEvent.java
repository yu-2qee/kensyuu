package com.example.travelVer2.event;

import org.springframework.context.ApplicationEvent;

import com.example.travelVer2.entity.User;

import lombok.Getter;

@Getter
public class SignupEvent extends ApplicationEvent{
	private String requestUrl;
	private User user;

public SignupEvent(Object source,User user,String requestUrl) {
	super(source);
	this.user=user;
	this.requestUrl=requestUrl;
}
}
