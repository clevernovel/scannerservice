package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.SectionDto;
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
  public SectionDto getSectionById(@PathVariable Long id) {    return sectionService.getSectionById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getSectionsByMultipleIds(@PathVariable List<Long> id) {    return sectionService.getSectionsByMultipleIds(id);
  }

  @RequestMapping(value = "/test/save", method = RequestMethod.POST)
  public SectionDto editUser(@RequestBody SectionDto request) {
    return sectionService.editUser(request);
  }
}

