package com.umnikov.scannerservice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;

public abstract class Dao<T> {
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

  public List<T> byIds(final List<Long> ids) {
    return session().byMultipleIds(clazz).multiLoad(ids);
  }

  protected Session session() {
    return sessionFactory.getCurrentSession();
  }

  public Serializable save(final T o) {
    return session().save(o);
  }

  public void flush() {
    session().flush();
  }
}
