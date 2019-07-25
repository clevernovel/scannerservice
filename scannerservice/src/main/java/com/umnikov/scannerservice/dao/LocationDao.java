package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Location;
import com.umnikov.scannerservice.entity.Location_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class LocationDao extends Dao<Location> {
  public LocationDao() {
    super(Location.class);
  }

  public Location saveAndFlush(Location location) {
    super.save(location);
    super.flush();
    return location;
  }

  public Location findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
    Root<Location> root = criteria.from(Location.class);
    Predicate predicate = builder.equal(root.get(Location_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Location> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
