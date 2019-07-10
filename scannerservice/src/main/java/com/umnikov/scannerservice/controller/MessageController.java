package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.services.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scanner")
public class MessageController {
  private final ScannerService scannerService;

  @Autowired
  public MessageController(ScannerService scannerService) {
    this.scannerService = scannerService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public UserDto getUserById(@PathVariable Long id) {
    return scannerService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return scannerService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return scannerService.editUser(request);
  }
}