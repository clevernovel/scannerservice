package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.LocationDto;
import com.umnikov.scannerservice.dao.LocationDao;
import com.umnikov.scannerservice.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class LocationService extends ServiceForController<LocationDto, Location> {
  private final LocationDao locationDao;

  @Autowired
  public LocationService(LocationDao locationDao) {
    super(locationDao);
    this.locationDao = locationDao;
  }

  public Location convertToModel(LocationDto locationDto) {
    Location location = locationDao.findByName(locationDto.name);
    if (location == null) {
      location = new Location();
      location.setName(locationDto.name);
      locationDao.saveAndFlush(location);
    }
    return location;
  }

  @Override
  public LocationDto edit(LocationDto dto) {
    return null;
  }

  public LocationDto convertToDto(Location location) {
    LocationDto locationDto = new LocationDto();
    locationDto.id = location.getId();
    locationDto.name = location.getName();
    return locationDto;
  }
}
