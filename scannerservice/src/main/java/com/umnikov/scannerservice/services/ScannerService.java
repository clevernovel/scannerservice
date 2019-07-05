package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.UserDao;
import com.umnikov.scannerservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class ScannerService {
  private final UserDao userDao;

  @Autowired
  public ScannerService(UserDao userDao) {
    this.userDao = userDao;
  }

  public UserDto getUserById(Integer id) {
    User user = userDao.byId(id == null ? 0 : (long) id);
    UserDto userDto = new UserDto();
    userDto.id = user.getId();
    userDto.name = user.getName();
    return userDto;
  }

  public UserDto editUser(UserDto request) {
    User user = new User();
    user.setName(request.name);
    userDao.saveAndFlush(user);
    return request;
  }
}
