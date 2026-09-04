package com.example.travel.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travel.entity.Reservation;
import com.example.travel.repository.AdminDashboardRepository;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminDashboardController {

    private final AdminDashboardRepository adminDashboardRepository;

    public AdminDashboardController(
            AdminDashboardRepository adminDashboardRepository) {

        this.adminDashboardRepository = adminDashboardRepository;
    }


    @GetMapping
    public String index(Model model) {

        // ==============================
        // 月別売上
        // ==============================

        int year = Year.now().getValue();

        Map<String, Long> monthlySales = new LinkedHashMap<>();

        for (int month = 1; month <= 12; month++) {

            Long sales =
                    adminDashboardRepository.getMonthlySales(year, month);

            monthlySales.put(month + "月", sales);
        }


        // ==============================
        // 人気の民宿ランキング
        // ==============================

        List<Object[]> popularHouses =
                adminDashboardRepository.findPopularHouses();


        // ==============================
        // 本日・明日・今週の予約
        // ==============================

        LocalDate today = LocalDate.now();

        LocalDate tomorrow = today.plusDays(1);

        LocalDate weekStart =
                today.with(DayOfWeek.MONDAY);

        LocalDate weekEnd =
                today.with(DayOfWeek.SUNDAY);


        // 本日の予約
        List<Reservation> todayReservations =
                adminDashboardRepository
                        .findByCheckinDateOrderByCreatedAtAsc(today);


        // 明日の予約
        List<Reservation> tomorrowReservations =
                adminDashboardRepository
                        .findByCheckinDateOrderByCreatedAtAsc(tomorrow);


        // 今週の予約
        List<Reservation> weekReservations =
                adminDashboardRepository
                        .findByCheckinDateBetweenOrderByCheckinDateAsc(
                                weekStart,
                                weekEnd
                        );


        // ==============================
        // 件数
        // ==============================

        int todayCount = todayReservations.size();

        int tomorrowCount = tomorrowReservations.size();

        int weekCount = weekReservations.size();


        // ==============================
        // HTMLへ渡す
        // ==============================

        model.addAttribute("monthlySales", monthlySales);

        model.addAttribute("popularHouses", popularHouses);

        model.addAttribute("todayReservations", todayReservations);

        model.addAttribute("tomorrowReservations", tomorrowReservations);

        model.addAttribute("weekReservations", weekReservations);

        model.addAttribute("todayCount", todayCount);

        model.addAttribute("tomorrowCount", tomorrowCount);

        model.addAttribute("weekCount", weekCount);

        model.addAttribute("year", year);


        return "admin/dashboard";
    }
}