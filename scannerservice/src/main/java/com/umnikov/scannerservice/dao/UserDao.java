package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends Dao<User> {
  public UserDao() {
    super(User.class);
  }

  public User saveAndFlush(User user) {
    super.save(user);
    super.flush();
    return user;
  }
}
