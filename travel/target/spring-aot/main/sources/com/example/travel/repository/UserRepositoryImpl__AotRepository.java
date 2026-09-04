package com.example.travel.repository;

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
 * AOT generated JPA repository implementation for {@link UserRepository}.
 */
@Generated
public class UserRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public UserRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link UserRepository#findByEmail(java.lang.String)}.
   */
  public User findByEmail(String email) {
    String queryString = "SELECT u FROM User u WHERE u.email = :email";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("email", email);

    return (User) convertOne(query.getSingleResultOrNull(), false, User.class);
  }

  /**
   * AOT generated implementation of {@link UserRepository#findByNameLikeOrFuriganaLike(java.lang.String,java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<User> findByNameLikeOrFuriganaLike(String nameKeyword, String Furiganakeyword,
      Pageable pageable) {
    String queryString = "SELECT u FROM User u WHERE u.name LIKE :nameKeyword ESCAPE '\\' OR u.furigana LIKE :Furiganakeyword ESCAPE '\\'";
    String countQueryString = "SELECT COUNT(u) FROM User u WHERE u.name LIKE :nameKeyword ESCAPE '\\' OR u.furigana LIKE :Furiganakeyword ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), User.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("nameKeyword", nameKeyword);
    query.setParameter("Furiganakeyword", Furiganakeyword);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("nameKeyword", nameKeyword);
      countQuery.setParameter("Furiganakeyword", Furiganakeyword);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<User>) query.getResultList(), pageable_1, countAll);
  }
}
