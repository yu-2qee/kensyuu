package com.example.travel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.travel.entity.House;
import com.example.travel.entity.Reservation;
import com.example.travel.entity.User;
import com.example.travel.form.ReservationRegisterForm;
import com.example.travel.repository.HouseRepository;
import com.example.travel.repository.ReservationRepository;
import com.example.travel.repository.UserRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final HouseRepository houseRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, HouseRepository houseRepository,
            UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
    }

    // フォームから直接登録する場合(既存)
    @Transactional
    public void create(ReservationRegisterForm reservationRegisterForm) {
        Reservation reservation = new Reservation();

        House house = houseRepository.getReferenceById(reservationRegisterForm.getHouseId());
        User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());

        LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
        LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());

        reservation.setHouse(house);
        reservation.setUser(user);
        reservation.setCheckinDate(checkinDate);
        reservation.setCheckoutDate(checkoutDate);
        reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
        reservation.setAmount(reservationRegisterForm.getAmount());

        reservationRepository.save(reservation);
    }

    // Stripe Webhookから、決済完了後のメタデータを使って登録する場合(追加)
    @Transactional
    public void create(Map<String, String> paymentIntentObject) {
        Reservation reservation = new Reservation();

        House house = houseRepository.getReferenceById(Integer.parseInt(paymentIntentObject.get("houseId")));
        User user = userRepository.getReferenceById(Integer.parseInt(paymentIntentObject.get("userId")));

        LocalDate checkinDate = LocalDate.parse(paymentIntentObject.get("checkinDate"));
        LocalDate checkoutDate = LocalDate.parse(paymentIntentObject.get("checkoutDate"));

        reservation.setHouse(house);
        reservation.setUser(user);
        reservation.setCheckinDate(checkinDate);
        reservation.setCheckoutDate(checkoutDate);
        reservation.setNumberOfPeople(Integer.parseInt(paymentIntentObject.get("numberOfPeople")));
        reservation.setAmount(Integer.parseInt(paymentIntentObject.get("amount")));

        reservationRepository.save(reservation);
    }

    // 宿泊人数が定員以下かどうかをチェックする
    public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
        return numberOfPeople <= capacity;
    }

    // 宿泊料金を計算する
    public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
        long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
        int amount = price * (int) numberOfNights;
        return amount;
    }
}