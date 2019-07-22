package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends Dao<Account> {
  public AccountDao() {
    super(Account.class);
  }

  public Account saveAndFlush(Account account) {
    super.save(account);
    super.flush();
    return account;
  }
}
