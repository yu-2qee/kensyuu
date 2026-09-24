package com.example.travelVar3.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.travelVar3.entity.House;
import com.example.travelVar3.entity.Reservation;
import com.example.travelVar3.repository.HouseRepository;
import com.example.travelVar3.repository.ReservationRepository;

@Controller
public class HomeController {
	private final HouseRepository houseRepository;
	private final ReservationRepository reservationRepository;

	public HomeController(HouseRepository houseRepository, ReservationRepository reservationRepository) {
		this.houseRepository = houseRepository;
		this.reservationRepository = reservationRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<House> newHouses = houseRepository.findTop10ByOrderByCreatedAtDesc();
		model.addAttribute("newHouses", newHouses);
		
		List<Reservation> allReservations = reservationRepository.findAll();
		//予約件数とカウント
		Map<House, Long> count = allReservations.stream()
				.collect(Collectors.groupingBy(Reservation::getHouse, Collectors.counting()));
		
		List<HouseRanking> popularHouses = count.entrySet().stream()
				.sorted((a, b) -> (int) (b.getValue() - a.getValue()))
				.limit(5)
				.map(entry -> new HouseRanking(entry.getKey().getId(), entry.getKey().getName()))
				.collect(Collectors.toList());
		model.addAttribute("popularHouses", popularHouses);
		return "index";
	}
}
