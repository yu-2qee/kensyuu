package com.example.travelVar3.controller;

public class HouseRanking {
	private final Integer id;
	private final String name;

	public HouseRanking(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}