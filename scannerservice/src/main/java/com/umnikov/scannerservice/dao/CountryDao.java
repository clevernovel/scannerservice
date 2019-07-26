package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Country;
import com.umnikov.scannerservice.entity.Country_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryDao extends Dao<Country> {
  public CountryDao() {
    super(Country.class);
  }

  public Country saveAndFlush(Country country) {
    super.save(country);
    super.flush();
    return country;
  }

  @Override
  public List<Country> all() {
    return getAll();
  }

  public Country findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
    Root<Country> root = criteria.from(Country.class);
    Predicate predicate = builder.equal(root.get(Country_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Country> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
