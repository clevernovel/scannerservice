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

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public EquipmentDto byId(@PathVariable Long id) {
    return equipmentService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List all() {
    return equipmentService.all();
  }


  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public EquipmentDto save(@RequestBody EquipmentDto request) {
    return equipmentService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public EquipmentDto edit(@RequestBody EquipmentDto request) {
    return equipmentService.edit(request);
  }
}

