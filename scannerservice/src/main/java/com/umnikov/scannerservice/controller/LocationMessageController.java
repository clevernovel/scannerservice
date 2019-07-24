package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.LocationDto;
import com.umnikov.scannerlib.dto.UserDto;
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
  public LocationDto getUserById(@PathVariable Long id) {
    return locationService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return locationService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return locationService.editUser(request);
  }
}

