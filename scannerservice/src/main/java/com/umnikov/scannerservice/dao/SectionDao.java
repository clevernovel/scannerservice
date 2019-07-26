package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Section;
import com.umnikov.scannerservice.entity.Section_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SectionDao extends Dao<Section> {
  public SectionDao() {
    super(Section.class);
  }

  public Section saveAndFlush(Section section) {
    super.save(section);
    super.flush();
    return section;
  }

  @Override
  public List<Section> all() {
    return getAll();
  }

  public Section findByName(String name) {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    CriteriaQuery<Section> criteria = builder.createQuery(Section.class);
    Root<Section> root = criteria.from(Section.class);
    Predicate predicate = builder.equal(root.get(Section_.name), name);
    criteria.select(root).distinct(true).where(predicate);
    TypedQuery<Section> query = session().createQuery(criteria);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
