package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.UserDao;
import com.umnikov.scannerservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class ScannerService {
  private final UserDao userDao;

  @Autowired
  public ScannerService(UserDao userDao) {
    this.userDao = userDao;
  }

  public UserDto getUserById(Long id) {
    User user = userDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = user.getId();
    userDto.name = user.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<User> list = userDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    User user = new User();
    user.setName(request.name);
    userDao.saveAndFlush(user);
    return request;
  }
}
