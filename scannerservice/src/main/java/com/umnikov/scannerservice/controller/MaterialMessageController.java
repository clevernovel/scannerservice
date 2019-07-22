package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialMessageController {
  private final MaterialService materialService;

  @Autowired
  public MaterialMessageController(MaterialService materialService) {
    this.materialService = materialService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public UserDto getUserById(@PathVariable Long id) {
    return materialService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return materialService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return materialService.editUser(request);
  }
}

