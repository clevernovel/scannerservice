package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.CountryDto;
import com.umnikov.scannerservice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
  private final CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public CountryDto byId(@PathVariable Long id) {
    return countryService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<CountryDto> all() {
    return countryService.all();
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public CountryDto edit(@RequestBody CountryDto request) {
    return countryService.edit(request);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public CountryDto save(@RequestBody CountryDto request) {
    return countryService.save(request);
  }
}

