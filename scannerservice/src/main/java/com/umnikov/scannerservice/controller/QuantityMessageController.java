package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.QuantityDto;
import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.services.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityMessageController {
  private final QuantityService quantityService;

  @Autowired
  public QuantityMessageController(QuantityService quantityService) {
    this.quantityService = quantityService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public QuantityDto getQuantityById(@PathVariable Long id) {
    return quantityService.getQuantityById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getQuantitiesByMultipleIds(@PathVariable List<Long> id) {
    return quantityService.getQuantitiesByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public QuantityDto editUser(@RequestBody QuantityDto request) {
    return quantityService.editUser(request);
  }
}

