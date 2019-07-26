package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Company;
import com.umnikov.scannerservice.entity.Company_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CompanyDao extends Dao<Company> {
  public CompanyDao() {
    super(Company.class);
  }

  public Company saveAndFlush(Company company) {
    super.save(company);
    super.flush();
    return company;
  }

  @Override
  public List<Company> all() {
    return getAll();
  }

  public Company findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Company> criteria = builder.createQuery(Company.class);
    Root<Company> root = criteria.from(Company.class);
    Predicate predicate = builder.equal(root.get(Company_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Company> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
