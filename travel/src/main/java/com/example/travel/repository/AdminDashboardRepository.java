package com.example.travel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travel.entity.Reservation;

public interface AdminDashboardRepository extends JpaRepository<Reservation, Integer> {

    // 月別売上
    @Query("""
        SELECT COALESCE(SUM(r.amount), 0)
        FROM Reservation r
        WHERE YEAR(r.createdAt) = :year
        AND MONTH(r.createdAt) = :month
    """)
    Long getMonthlySales(
            @Param("year") int year,
            @Param("month") int month
    );


    // 人気の民宿ランキング
    @Query("""
        SELECT r.house.name, COUNT(r)
        FROM Reservation r
        GROUP BY r.house.id, r.house.name
        ORDER BY COUNT(r) DESC
    """)
    List<Object[]> findPopularHouses();


    // 本日の予約
    List<Reservation> findByCheckinDateOrderByCreatedAtAsc(
            LocalDate checkinDate
    );


    // 指定期間の予約
    List<Reservation> findByCheckinDateBetweenOrderByCheckinDateAsc(
            LocalDate startDate,
            LocalDate endDate
    );
}