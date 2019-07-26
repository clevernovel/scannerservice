package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.AccountDto;
import com.umnikov.scannerservice.dao.AccountDao;
import com.umnikov.scannerservice.entity.Account;
import com.umnikov.scannerservice.entity.Company;
import com.umnikov.scannerservice.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class AccountService extends ServiceForController<AccountDto, Account> {
  private final AccountDao accountDao;
  private final CompanyService companyService;
  private final CountryService countryService;

  @Autowired
  public AccountService(AccountDao accountDao, CompanyService companyService, CountryService countryService) {
    super(accountDao);
    this.accountDao = accountDao;
    this.companyService = companyService;
    this.countryService = countryService;
  }

  @Override
  public AccountDto convertToDto(Account account) {
    AccountDto accountDto = new AccountDto();
    accountDto.id = account.getId();
    accountDto.country = countryService.convertToDto(account.getCountry());
    accountDto.company = companyService.convertToDto(account.getCompany());
    return accountDto;
  }

  @Override
  public Account convertToModel(AccountDto dto) {
    Company company = companyService.convertToModel(dto.company);
    Country country = countryService.convertToModel(dto.country);
    Account account = accountDao.findByCompanyCountry(company, country);
    if (account == null) {
      account = new Account();
      account.setCompany(company);
      account.setCountry(country);
      accountDao.saveAndFlush(account);
    }
    return account;
  }

  @Override
  public AccountDto edit(AccountDto dto) {
    return null;
  }
}
