package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Account;
import com.umnikov.scannerservice.entity.Account_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class AccountDao extends Dao<Account> {
  public AccountDao() {
    super(Account.class);
  }

  public Account saveAndFlush(Account account) {
    super.save(account);
    super.flush();
    return account;
  }

  public Account findByName(Long company, Long country) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
    Root<Account> root = criteria.from(Account.class);
    Predicate predicateCompany = builder.equal(root.get(Account_.company), company);
    Predicate predicateCountry = builder.equal(root.get(Account_.country), country);
    criteria.select(root).distinct(true).where(predicateCompany);
    criteria.select(root).distinct(true).where(predicateCountry);
    TypedQuery<Account> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
