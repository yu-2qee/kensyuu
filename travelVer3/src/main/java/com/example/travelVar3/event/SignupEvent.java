package com.example.travelVar3.event;

import org.springframework.context.ApplicationEvent;

import com.example.travelVar3.entity.User;

import lombok.Getter;

@Getter
public class SignupEvent extends ApplicationEvent {
private User user;
private String rquestUrl;
public SignupEvent(Object source,User user,String requestUrl) {
super (source);
this.user=user;
this.rquestUrl=requestUrl;
}
}
