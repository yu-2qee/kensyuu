package com.example.travel.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.query.Param;

/**
 * AOT generated JPA repository implementation for {@link AdminDashboardRepository}.
 */
@Generated
public class AdminDashboardRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public AdminDashboardRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link AdminDashboardRepository#findPopularHouses()}.
   */
  public List<Object[]> findPopularHouses() {
    String queryString = "    SELECT r.house.name, COUNT(r)\n"
            + "    FROM Reservation r\n"
            + "    GROUP BY r.house.id, r.house.name\n"
            + "    ORDER BY COUNT(r) DESC\n";
    Query query = this.entityManager.createQuery(queryString);

    return (List<Object[]>) convertMany(query.getResultList(), false, Object[].class);
  }

  /**
   * AOT generated implementation of {@link AdminDashboardRepository#getMonthlySales(int,int)}.
   */
  public Integer getMonthlySales(@Param("year") int year, @Param("month") int month) {
    String queryString = "    SELECT COALESCE(SUM(r.amount), 0)\n"
            + "    FROM Reservation r\n"
            + "    WHERE YEAR(r.createdAt) = :year\n"
            + "    AND MONTH(r.createdAt) = :month\n";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("year", year);
    query.setParameter("month", month);

    return (Integer) convertOne(query.getSingleResultOrNull(), false, Integer.class);
  }
}
