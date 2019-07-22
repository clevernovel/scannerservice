package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionMessageController {
  private final SectionService sectionService;

  @Autowired
  public SectionMessageController(SectionService sectionService) { this.sectionService = sectionService; }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public UserDto getUserById(@PathVariable Long id) {
    return sectionService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return sectionService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return sectionService.editUser(request);
  }
}

