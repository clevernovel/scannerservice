package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.SectionDto;
import com.umnikov.scannerservice.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {
  private final SectionService sectionService;

  @Autowired
  public SectionController(SectionService sectionService) {
    this.sectionService = sectionService;
  }

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public SectionDto byId(@PathVariable Long id) {
    return sectionService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List all() {
    return sectionService.all();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public SectionDto save(@RequestBody SectionDto request) {
    return sectionService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public SectionDto edit(@RequestBody SectionDto request) {
    return sectionService.edit(request);
  }
}

