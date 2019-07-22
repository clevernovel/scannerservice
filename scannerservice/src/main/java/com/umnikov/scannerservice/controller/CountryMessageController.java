package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryMessageController {
  private final CountryService countryService;

  @Autowired
  public CountryMessageController(CountryService countryService) {
    this.countryService = countryService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public UserDto getUserById(@PathVariable Long id) {
    return countryService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return countryService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return countryService.editUser(request);
  }
}

