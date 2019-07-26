package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Account;
import com.umnikov.scannerservice.entity.Account_;
import com.umnikov.scannerservice.entity.Company;
import com.umnikov.scannerservice.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

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

  @Override
  public List<Account> all() {
    return getAll();
  }

  public Account findByCompanyCountry(Company company, Country country) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
    Root<Account> root = criteria.from(Account.class);
    Predicate predicate = builder.and(builder.equal(root.get(Account_.company), company),
        builder.equal(root.get(Account_.country), country));
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Account> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
