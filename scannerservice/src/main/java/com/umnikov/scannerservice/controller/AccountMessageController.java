package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.AccountDto;
import com.umnikov.scannerlib.dto.UserDto;
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
  public AccountDto getUserById(@PathVariable Long id) {
    return accountService.getUserById(id);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getUsersByMultipleIds(@PathVariable List<Long> id) {
    return accountService.getUsersByMultipleIds(id);
  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public AccountDto editUser(@RequestBody AccountDto request) {
    return accountService.editAccount(request);
  }
}

