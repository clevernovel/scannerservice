package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.EquipmentDto;
import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentMessageController {
  private final EquipmentService equipmentService;

  @Autowired
  public EquipmentMessageController(EquipmentService equipmentService) {
    this.equipmentService = equipmentService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public EquipmentDto getUserById(@PathVariable Long id) {
    return equipmentService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return equipmentService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public UserDto editUser(@RequestBody UserDto request) {
    return equipmentService.editUser(request);
  }
}

