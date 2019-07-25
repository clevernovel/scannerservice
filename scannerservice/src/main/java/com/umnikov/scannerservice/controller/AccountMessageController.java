package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.AccountDto;
import com.umnikov.scannerservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountMessageController {
  private final AccountService accountService;

  @Autowired
  public AccountMessageController(AccountService accountService) {
    this.accountService = accountService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public AccountDto getAccountById(@PathVariable Long id) {
    return accountService.getAccountById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getAccountsByMultipleIds(@PathVariable List<Long> id) {
    return accountService.getAccountsByMultipleIds(id);
  }

  @RequestMapping(value = "/test/save", method = RequestMethod.POST)
  public AccountDto saveNewElement(@RequestBody AccountDto request) {
    return accountService.convertToDto(accountService.createModel(request));
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public AccountDto editUser(@RequestBody AccountDto request) {
    return accountService.editAccount(request);
  }
}

