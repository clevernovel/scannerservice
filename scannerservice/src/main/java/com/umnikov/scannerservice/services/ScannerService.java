package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class ScannerService {
  public UserDto getUserById() {
    UserDto user = new UserDto();
    user.id = 1;
    user.name = "Roma";
    return user;
  }

  public UserDto editUser(UserDto request) {
    request.validation();
    request.id++;
    return request;
  }
}
