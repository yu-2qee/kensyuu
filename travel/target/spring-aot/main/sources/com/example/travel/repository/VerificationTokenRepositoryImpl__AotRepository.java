package com.example.travel.repository;

import com.example.travel.entity.VerificationToken;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link VerificationTokenRepository}.
 */
@Generated
public class VerificationTokenRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public VerificationTokenRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link VerificationTokenRepository#findByToken(java.lang.String)}.
   */
  public VerificationToken findByToken(String token) {
    String queryString = "SELECT v FROM VerificationToken v WHERE v.token = :token";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("token", token);

    return (VerificationToken) convertOne(query.getSingleResultOrNull(), false, VerificationToken.class);
  }
}
