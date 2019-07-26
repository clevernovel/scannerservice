package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.MaterialDto;
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
  public MaterialDto getMaterialById(@PathVariable Long id) {
    return materialService.getMaterialById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getMaterialsByMultipleIds(@PathVariable List<Long> id) {
    return materialService.getMaterialsByMultipleIds(id);
  }

  @RequestMapping(value = "/test/save", method = RequestMethod.POST)
  public MaterialDto editUser(@RequestBody MaterialDto request) {
    return materialService.editUser(request);
  }
}

