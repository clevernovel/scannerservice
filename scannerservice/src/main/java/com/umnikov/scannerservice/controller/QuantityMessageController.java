package com.umnikov.scannerservice.controller;

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
  public UserDto getUserById(@PathVariable Long id) {
    return quantityService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return quantityService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return quantityService.editUser(request);
  }
}

