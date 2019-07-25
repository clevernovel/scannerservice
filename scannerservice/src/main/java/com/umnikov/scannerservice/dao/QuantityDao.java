package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Location;
import com.umnikov.scannerservice.entity.Location_;
import com.umnikov.scannerservice.entity.Quantity;
import com.umnikov.scannerservice.entity.Quantity_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class QuantityDao extends Dao<Quantity> {
  public QuantityDao() {
    super(Quantity.class);
  }

  public Quantity saveAndFlush(Quantity quantity) {
    super.save(quantity);
    super.flush();
    return quantity;
  }

  public Quantity findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Quantity> criteria = builder.createQuery(Quantity.class);
    Root<Quantity> root = criteria.from(Quantity.class);
    Predicate predicate = builder.equal(root.get(Quantity_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Quantity> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
