package com.example.travel.repository;

import com.example.travel.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link RoleRepository}.
 */
@Generated
public class RoleRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public RoleRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link RoleRepository#findByName(java.lang.String)}.
   */
  public Role findByName(String name) {
    String queryString = "SELECT r FROM Role r WHERE r.name = :name";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("name", name);

    return (Role) convertOne(query.getSingleResultOrNull(), false, Role.class);
  }
}
