package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travel.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Integer> 
{
public VerificationToken findByToken(String token);
}
