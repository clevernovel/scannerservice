package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Material;
import com.umnikov.scannerservice.entity.Material_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MaterialDao extends Dao<Material> {
  public MaterialDao() {
    super(Material.class);
  }

  public Material saveAndFlush(Material material) {
    super.save(material);
    super.flush();
    return material;
  }

  @Override
  public List<Material> all() {
    return getAll();
  }

  public Material findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Material> criteria = builder.createQuery(Material.class);
    Root<Material> root = criteria.from(Material.class);
    Predicate predicate = builder.equal(root.get(Material_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Material> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
