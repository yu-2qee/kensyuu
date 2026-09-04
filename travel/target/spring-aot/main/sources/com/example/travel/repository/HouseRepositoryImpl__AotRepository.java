package com.example.travel.repository;

import com.example.travel.entity.House;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Integer;
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
 * AOT generated JPA repository implementation for {@link HouseRepository}.
 */
@Generated
public class HouseRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public HouseRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findAllByOrderByCreatedAtDesc(org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findAllByOrderByCreatedAtDesc(Pageable pageable) {
    String queryString = "SELECT h FROM House h ORDER BY h.createdAt desc";
    String countQueryString = "SELECT COUNT(h) FROM House h";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findAllByOrderByPriceAsc(org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findAllByOrderByPriceAsc(Pageable pageable) {
    String queryString = "SELECT h FROM House h ORDER BY h.price asc";
    String countQueryString = "SELECT COUNT(h) FROM House h";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByAddressLike(java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByAddressLike(String area, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.address LIKE :area ESCAPE '\\'";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.address LIKE :area ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("area", area);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("area", area);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByAddressLikeOrderByCreatedAtDesc(java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.address LIKE :area ESCAPE '\\' ORDER BY h.createdAt desc";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.address LIKE :area ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("area", area);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("area", area);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByAddressLikeOrderByPriceAsc(java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByAddressLikeOrderByPriceAsc(String area, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.address LIKE :area ESCAPE '\\' ORDER BY h.price asc";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.address LIKE :area ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("area", area);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("area", area);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByNameLike(java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByNameLike(String keyword, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.name LIKE :keyword ESCAPE '\\'";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.name LIKE :keyword ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("keyword", keyword);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("keyword", keyword);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByNameLikeOrAddressLike(java.lang.String,java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByNameLikeOrAddressLike(String nameKeyword, String addressKeyword,
      Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.name LIKE :nameKeyword ESCAPE '\\' OR h.address LIKE :addressKeyword ESCAPE '\\'";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.name LIKE :nameKeyword ESCAPE '\\' OR h.address LIKE :addressKeyword ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("nameKeyword", nameKeyword);
    query.setParameter("addressKeyword", addressKeyword);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("nameKeyword", nameKeyword);
      countQuery.setParameter("addressKeyword", addressKeyword);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByNameLikeOrAddressLikeOrderByCreatedAtDesc(java.lang.String,java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword,
      String addressKeyword, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.name LIKE :nameKeyword ESCAPE '\\' OR h.address LIKE :addressKeyword ESCAPE '\\' ORDER BY h.createdAt desc";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.name LIKE :nameKeyword ESCAPE '\\' OR h.address LIKE :addressKeyword ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("nameKeyword", nameKeyword);
    query.setParameter("addressKeyword", addressKeyword);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("nameKeyword", nameKeyword);
      countQuery.setParameter("addressKeyword", addressKeyword);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByNameLikeOrAddressLikeOrderByPriceAsc(java.lang.String,java.lang.String,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByNameLikeOrAddressLikeOrderByPriceAsc(String nameKeyword,
      String addressKeyword, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.name LIKE :nameKeyword ESCAPE '\\' OR h.address LIKE :addressKeyword ESCAPE '\\' ORDER BY h.price asc";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.name LIKE :nameKeyword ESCAPE '\\' OR h.address LIKE :addressKeyword ESCAPE '\\'";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("nameKeyword", nameKeyword);
    query.setParameter("addressKeyword", addressKeyword);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("nameKeyword", nameKeyword);
      countQuery.setParameter("addressKeyword", addressKeyword);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByPriceLessThanEqual(java.lang.Integer,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByPriceLessThanEqual(Integer price, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.price <= :price";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.price <= :price";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("price", price);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("price", price);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByPriceLessThanEqualOrderByCreatedAtDesc(java.lang.Integer,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price,
      Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.price <= :price ORDER BY h.createdAt desc";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.price <= :price";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("price", price);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("price", price);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findByPriceLessThanEqualOrderByPriceAsc(java.lang.Integer,org.springframework.data.domain.Pageable)}.
   */
  public Page<House> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable) {
    String queryString = "SELECT h FROM House h WHERE h.price <= :price ORDER BY h.price asc";
    String countQueryString = "SELECT COUNT(h) FROM House h WHERE h.price <= :price";
    Pageable pageable_1 = pageable != null ? pageable : Pageable.unpaged();
    if (pageable_1.getSort().isSorted()) {
      DeclaredQuery declaredQuery = DeclaredQuery.jpqlQuery(queryString);
      queryString = rewriteQuery(declaredQuery, pageable_1.getSort(), House.class);
    }
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("price", price);
    if (pageable_1.isPaged()) {
      query.setFirstResult(Long.valueOf(pageable_1.getOffset()).intValue());
      query.setMaxResults(pageable_1.getPageSize());
    }
    LongSupplier countAll = () -> {
      Query countQuery = this.entityManager.createQuery(countQueryString);
      countQuery.setParameter("price", price);
      return getCount(countQuery);
    };

    return PageableExecutionUtils.getPage((List<House>) query.getResultList(), pageable_1, countAll);
  }

  /**
   * AOT generated implementation of {@link HouseRepository#findTop10ByOrderByCreatedAtDesc()}.
   */
  public List<House> findTop10ByOrderByCreatedAtDesc() {
    String queryString = "SELECT h FROM House h ORDER BY h.createdAt desc";
    Query query = this.entityManager.createQuery(queryString);
    if (query.getMaxResults() != Integer.MAX_VALUE) {
      if (query.getMaxResults() > 10 && query.getFirstResult() > 0) {
        query.setFirstResult(query.getFirstResult() - (query.getMaxResults() - 10));
      }
    }
    query.setMaxResults(10);

    return (List<House>) query.getResultList();
  }
}
