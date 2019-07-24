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

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public CompanyDto getUserById(@PathVariable Long id) {
    return companyService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return companyService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public CompanyDto editUser(@RequestBody CompanyDto request) {
    return companyService.editUser(request);
  }
}

