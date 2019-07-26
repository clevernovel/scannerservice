package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.QuantityDto;
import com.umnikov.scannerservice.services.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityController {
  private final QuantityService quantityService;

  @Autowired
  public QuantityController(QuantityService quantityService) {
    this.quantityService = quantityService;
  }

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public QuantityDto getQuantityById(@PathVariable Long id) {
    return quantityService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List all() {
    return quantityService.all();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public QuantityDto save(@RequestBody QuantityDto request) {
    return quantityService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public QuantityDto edit(@RequestBody QuantityDto request) {
    return quantityService.edit(request);
  }
}

