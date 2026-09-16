package com.example.travelVar1.service;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travelVar1.entity.Role;
import com.example.travelVar1.entity.User;
import com.example.travelVar1.form.SignupForm;
import com.example.travelVar1.form.UserEditForm;
import com.example.travelVar1.repository.RoleRepository;
import com.example.travelVar1.repository.UserRepository;

@Service
public class UserService {
private final UserRepository userRepository;
private final RoleRepository roleRepository;
private final PasswordEncoder passwordEncoder;
public UserService(UserRepository userRepository,
		RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
this.userRepository=userRepository;
this.roleRepository=roleRepository;
this.passwordEncoder=passwordEncoder;
}
@Transactional
public User create(SignupForm signupForm) {
	User user=new User();
	Role role=roleRepository.findByName("ROLE_GENERAL");

	user.setName(signupForm.getName());
	user.setFurigana(signupForm.getFurigana());
	user.setPostalCode(signupForm.getPostalCode());
	user.setAddress(signupForm.getAddress());
	user.setPhoneNumber(signupForm.getPhoneNumber());
	user.setEmail(signupForm.getEmail());
	user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
	user.setRole(role);
	user.setEnabled(false);
	return userRepository.save(user);
}

//メールチェック
public boolean isEmailRegistered(String email) {
	User user=userRepository.findByEmail(email);
	return user !=null;
}
//passsチェック
public boolean isSamePassword(String password,String passwordConfilmation) {
	return password.equals(passwordConfilmation);
}

@Transactional

public void update(UserEditForm userEditForm) {

User user = userRepository.getReferenceById(userEditForm.getId());

user.setName(userEditForm.getName());
user.setFurigana(userEditForm.getFurigana());
user.setPostalCode(userEditForm.getPostalCode());
user.setAddress(userEditForm.getAddress());
user.setPhoneNumber(userEditForm.getPhoneNumber());
user.setEmail(userEditForm.getEmail());
userRepository.save(user);
}
public void enableUser(User user) {
	user.setEnabled(true);
	userRepository.save(user);
}
public boolean isEmailChanged(UserEditForm userEditForm) {
	User currentUser=userRepository.getReferenceById(userEditForm.getId());
	return  !userEditForm.getEmail().equals(currentUser.getEmail());
}
}