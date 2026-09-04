package com.example.travel.repository;

import com.example.travel.entity.Reservation;
import com.example.travel.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import java.util.function.LongSupplier;
import org.springframework.aot.generate.Generated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.DeclaredQuery;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.support.PageableExecutionUtils;

/**
 * AOT generated JPA repository implementation for {@link ReservationRepository}.
 */
@Generated
public class ReservationRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public ReservationRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link ReservationRepository#findByUserOrderByCreatedAtDesc(com.example.travel.entity.User,org.springframework.data.domain.Pageable)}.
   */
  public Page<Reservation> findByUserOrderByCreatedAtDesc(User user, Pageable pageable) {
    String queryString = "SELECT r FROM Reservation r WHERE r.user = :user ORDER BY r.createdAt desc";
    String countQueryString = "SELECT COUNT(r) FROM Reservation r WHERE r.user = :user";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), Reservation.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("user", user);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("user", user);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<Reservation>) query.getResultList(), pageable_1, countAll);
  }
}
