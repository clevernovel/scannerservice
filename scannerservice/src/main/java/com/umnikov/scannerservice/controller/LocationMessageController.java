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

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public LocationDto byId(@PathVariable Long id) {
    return locationService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List all() {
    return locationService.all();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public LocationDto save(@RequestBody LocationDto request) {
    return locationService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public LocationDto edit(@RequestBody LocationDto request) {
    return locationService.edit(request);
  }
}

