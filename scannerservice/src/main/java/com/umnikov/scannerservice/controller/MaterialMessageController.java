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

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public MaterialDto getMaterialById(@PathVariable Long id) {
    return materialService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List all() {
    return materialService.all();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public MaterialDto save(@RequestBody MaterialDto request) {
    return materialService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public MaterialDto edit(@RequestBody MaterialDto request) {
    return materialService.edit(request);
  }
}

