package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Equipment;
import com.umnikov.scannerservice.entity.Equipment_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EquipmentDao extends Dao<Equipment> {
  public EquipmentDao() {
    super(Equipment.class);
  }

  public Equipment saveAndFlush(Equipment equipment) {
    super.save(equipment);
    super.flush();
    return equipment;
  }

  @Override
  public List<Equipment> all() {
    return getAll();
  }

  public Equipment findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Equipment> criteria = builder.createQuery(Equipment.class);
    Root<Equipment> root = criteria.from(Equipment.class);
    Predicate predicate = builder.equal(root.get(Equipment_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Equipment> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
