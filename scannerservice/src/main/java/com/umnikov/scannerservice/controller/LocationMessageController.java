package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.LocationDto;
import com.umnikov.scannerservice.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationMessageController {
  private final LocationService locationService;

  @Autowired
  public LocationMessageController(LocationService locationService) {
    this.locationService = locationService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public LocationDto getLocationById(@PathVariable Long id) {
    return locationService.getLocationById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getLocationsByMultipleIds(@PathVariable List<Long> id) {
    return locationService.getLocationsByMultipleIds(id);
  }

  @RequestMapping(value = "/test/save", method = RequestMethod.POST)
  public LocationDto editUser(@RequestBody LocationDto request) {
    return locationService.editUser(request);
  }
}

