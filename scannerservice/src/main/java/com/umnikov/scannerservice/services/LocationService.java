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

  public LocationDto getLocationById(Long id) {
    Location location = locationDao.byId(id == null ? 0 : id);
    return convertToDto(location);
  }

  public List getLocationsByMultipleIds(List<Long> ids) {
    return locationDao.byIds(ids);
  }

  public LocationDto editUser(LocationDto request) {
    Location location = new Location();
    location.setName(request.name);
    locationDao.saveAndFlush(location);
    return request;
  }

  public Location createModelOrGetExisting(LocationDto locationDto) {
    Location location = locationDao.findByName(locationDto.name);
    if (location == null) {
      location = new Location();
      location.setName(locationDto.name);
      locationDao.saveAndFlush(location);
    }
    return location;
  }

  public LocationDto convertToDto(Location location) {
    LocationDto locationDto = new LocationDto();
    locationDto.id = location.getId();
    locationDto.name = location.getName();
    return locationDto;
  }
}
