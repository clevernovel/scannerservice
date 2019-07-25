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
  private final CompanyService companyService;
  private final CountryService countryService;

  @Autowired
  public AccountService(AccountDao accountDao, CompanyService companyService, CountryService countryService) {
    this.accountDao = accountDao;
    this.companyService = companyService;
    this.countryService = countryService;
  }

  public AccountDto getAccountById(Long id) {
    Account account = accountDao.byId(id == null ? 0 : id);
    return convertToDto(account);
  }

  public List getAccountsByMultipleIds(List<Long> ids) {
    List<Account> list = accountDao.byIds(ids);
    return list;
  }

  public AccountDto editAccount(AccountDto request) {
    Account account = new Account();
//    account.setCompany(request.company);
//    account.setCountry(request.country);
    accountDao.saveAndFlush(account);
    return request;
  }

  public AccountDto convertToDto(Account account) {
    AccountDto accountDto = new AccountDto();
    accountDto.id = account.getId();
    accountDto.country = countryService.convertToDto(account.getCountry());
    accountDto.company = companyService.convertToDto(account.getCompany());
    return accountDto;
  }

  public Account createModel(AccountDto request) {
    Account account = new Account();
    account.setCompany(companyService.createModelOrGetExisting(request.company));
    account.setCountry(countryService.createModelOrGetExisting(request.country));
    Account res = accountDao.saveAndFlush(account);
    return res;
  }

}
