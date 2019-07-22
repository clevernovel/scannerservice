package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Location;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDao extends Dao<Location> {
  public LocationDao() {
    super(Location.class);
  }

  public Location saveAndFlush(Location location) {
    super.save(location);
    super.flush();
    return location;
  }
}
