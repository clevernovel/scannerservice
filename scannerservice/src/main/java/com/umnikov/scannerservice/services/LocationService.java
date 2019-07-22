package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.LocationDao;
import com.umnikov.scannerservice.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class LocationService {
  private final LocationDao locationDao;

  @Autowired
  public LocationService(LocationDao locationDao) {
    this.locationDao = locationDao;
  }

  public UserDto getUserById(Long id) {
    Location location = locationDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = location.getId();
    userDto.name = location.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Location> list = locationDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Location location = new Location();
    location.setName(request.name);
    locationDao.saveAndFlush(location);
    return request;
  }
}
