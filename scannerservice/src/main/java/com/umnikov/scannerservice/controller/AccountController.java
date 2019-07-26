package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.AccountDto;
import com.umnikov.scannerservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public AccountDto byId(@PathVariable Long id) {
    return accountService.byId(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<AccountDto> all() {
    return accountService.all();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public AccountDto save(@RequestBody AccountDto request) {
    return accountService.save(request);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public AccountDto edit(@RequestBody AccountDto request) {
    return accountService.edit(request);
  }
}

