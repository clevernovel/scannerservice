package com.umnikov.scannerservice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class Dao<T> implements MainAction<T> {
  private final Class<T> clazz;
  @Autowired
  @Qualifier("scannerSessionFactory")
  private SessionFactory sessionFactory;

  public Dao(Class<T> clazz) {
    this.clazz = clazz;
  }

  public T byId(final Long id) {
    return session().get(clazz, id);
  }

  protected List<T> getAll() {
    CriteriaQuery<T> criteria = criteria();
    Root<T> root = criteria.from(clazz);
    criteria.select(root);
    return session().createQuery(criteria).getResultList();
  }

  private CriteriaQuery<T> criteria() {
    CriteriaBuilder builder = session().getCriteriaBuilder();
    return builder.createQuery(clazz);
  }

  public List<T> byIds(final List<Long> ids) {
    return session().byMultipleIds(clazz).multiLoad(ids);
  }

  Session session() {
    return sessionFactory.getCurrentSession();
  }

  public Serializable save(final T o) {
    return session().save(o);
  }

  public void flush() {
    session().flush();
  }
}
