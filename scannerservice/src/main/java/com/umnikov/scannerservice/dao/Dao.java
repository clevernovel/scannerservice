package com.umnikov.scannerservice.dao;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.entity.User;
import com.umnikov.scannerservice.exceptions.NotFoundException;
import com.umnikov.scannerservice.services.ScannerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.ArrayList;
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

  public List<T> byIds(final int ids) {
    List list = new ArrayList();
    UserDto userDto = new UserDto();
    UserDao userDao = new UserDao();
    ScannerService scannerService = new ScannerService(userDao);
    for (int i = 0; i < ids; i++) {
      scannerService.getUserById(i);
      list.add(userDao.byId((long) i));
    }
    return list;
  }

  private Session session() {
    return sessionFactory.getCurrentSession();
  }

  public Serializable save(final T o) {
    return session().save(o);
  }

  public void flush() {
    session().flush();
  }
}
