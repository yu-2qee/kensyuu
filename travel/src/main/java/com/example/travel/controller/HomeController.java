package com.example.travel.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.travel.entity.House;
import com.example.travel.repository.HouseRepository;


@Controller

public class HomeController {

private final HouseRepository houseRepository;


public HomeController(HouseRepository houseRepository) {

this.houseRepository = houseRepository;

}


@GetMapping("/")

public String index(Model model) {

List<House> newHouses = houseRepository.findTop10ByOrderByCreatedAtDesc();

model.addAttribute("newHouses", newHouses);


return "index";

}

}

