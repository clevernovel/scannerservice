package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.LocationDto;
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

  public LocationDto getUserById(Long id) {
    Location location = locationDao.byId(id == null ? 0 : id);
    return convertToDto(location);
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    return locationDao.byIds(ids);
  }

  public UserDto editUser(UserDto request) {
    Location location = new Location();
    location.setName(request.name);
    locationDao.saveAndFlush(location);
    return request;
  }

  public Location createModel() {
    Location item = new Location();
    item.setName("test");
    return locationDao.saveAndFlush(item);
  }

  public LocationDto convertToDto(Location location) {
    LocationDto locationDto = new LocationDto();
    locationDto.id = location.getId();
    locationDto.name = location.getName();
    return locationDto;
  }
}
