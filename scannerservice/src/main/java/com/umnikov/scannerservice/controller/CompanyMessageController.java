package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.CompanyDto;
import com.umnikov.scannerservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyMessageController {
  private final CompanyService companyService;

  @Autowired
  public CompanyMessageController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public CompanyDto byId(@PathVariable Long id) {
    return companyService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<CompanyDto> all() {
    return companyService.all();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public CompanyDto save(@RequestBody CompanyDto request) {
    return companyService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public CompanyDto edit(@RequestBody CompanyDto request) {
    return companyService.edit(request);
  }
}

