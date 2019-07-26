package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.EquipmentDto;
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
  public EquipmentDto getEquipmentById(@PathVariable Long id) {
    return equipmentService.getEquipmentById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getEquipmentsByMultipleIds(@PathVariable List<Long> id) {
    return equipmentService.getEquipmentsByMultipleIds(id);
  }


  @RequestMapping(value = "/test/save", method = RequestMethod.POST)
  public EquipmentDto editUser(@RequestBody EquipmentDto request) {
    return equipmentService.editUser(request);
  }
}

