package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.AccountDto;
import com.umnikov.scannerservice.dao.AccountDao;
import com.umnikov.scannerservice.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class AccountService {
  private final AccountDao accountDao;

  @Autowired
  public AccountService(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

  public AccountDto getUserById(Long id) {
    Account account = accountDao.byId(id == null ? 0 : id);
    AccountDto accountDto = new AccountDto();
    accountDto.id = account.getId();
    accountDto.company = account.getCompany();
    accountDto.country = account.getCountry();
    return accountDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Account> list = accountDao.byIds(ids);
    return list;
  }

  public AccountDto editAccount(AccountDto request) {
    Account account = new Account();
    account.setCompany(request.company);
    account.setCountry(request.country);
    accountDao.saveAndFlush(account);
    return request;
  }
}
