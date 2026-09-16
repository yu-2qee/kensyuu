package com.example.travelVar1.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.travelVar1.entity.House;
import com.example.travelVar1.entity.Reservation;
import com.example.travelVar1.entity.User;
import com.example.travelVar1.form.ReservationRegisterForm;
import com.example.travelVar1.repository.HouseRepository;
import com.example.travelVar1.repository.ReservationRepository;
import com.example.travelVar1.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;
	public ReservationService(ReservationRepository reservationRepository,HouseRepository houseRepository,
	UserRepository userRepository){
		this.reservationRepository=reservationRepository;
		this.houseRepository=houseRepository;
		this.userRepository=userRepository;
	}
	
@Transactional
public void create(ReservationRegisterForm reservationRegisterForm) {
	Reservation reservation=new Reservation();
	House house=houseRepository.getReferenceById(reservationRegisterForm.getHouseId());
	User user=userRepository.getReferenceById(reservationRegisterForm.getUserId());
	LocalDate checkinDate=LocalDate.parse(reservationRegisterForm.getCheckinDate());
	LocalDate chackoutDate=LocalDate.parse(reservationRegisterForm.getCheckoutDate());
	reservation.setHouse(house);
	reservation.setUser(user);
	reservation.setCheckinDate(checkinDate);
	reservation.setCheckoutDate(chackoutDate);
	reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
	reservation.setAmount(reservationRegisterForm.getAmount());
	reservationRepository.save(reservation);
}
	
public boolean isWithinCapacity(Integer numberOfPeople,Integer capacity) {
	return numberOfPeople<=capacity;
}//料金計算
public Integer calculateAmount(LocalDate checkinDate,LocalDate checkoutDate,Integer price) {
	long numberOfNights=ChronoUnit.DAYS.between(checkinDate,checkoutDate);
	int amount=price*(int)numberOfNights;
	return amount;
}
@Transactional

public void create(Map<String, String> paymentIntentObject) {

Reservation reservation = new Reservation();

Integer houseId = Integer.valueOf(paymentIntentObject.get("houseId"));
Integer userId = Integer.valueOf(paymentIntentObject.get("userId"));

House house = houseRepository.getReferenceById(houseId);
User user = userRepository.getReferenceById(userId);
LocalDate checkinDate = LocalDate.parse(paymentIntentObject.get("checkinDate"));
LocalDate checkoutDate = LocalDate.parse(paymentIntentObject.get("checkoutDate"));
Integer numberOfPeople = Integer.valueOf(paymentIntentObject.get("numberOfPeople"));
Integer amount = Integer.valueOf(paymentIntentObject.get("amount"));

reservation.setHouse(house);
reservation.setUser(user);
reservation.setCheckinDate(checkinDate);
reservation.setCheckoutDate(checkoutDate);
reservation.setNumberOfPeople(numberOfPeople);
reservation.setAmount(amount);
reservationRepository.save(reservation);
}
}
