package com.example.travelVar1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travelVar1.entity.Reservation;
import com.example.travelVar1.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
public Page<Reservation>findByUserOrderByCreatedAtDesc(User user,Pageable pageable);
}
