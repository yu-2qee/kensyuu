package com.example.travelVar1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travelVar1.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
public Role findByName(String name);
}
