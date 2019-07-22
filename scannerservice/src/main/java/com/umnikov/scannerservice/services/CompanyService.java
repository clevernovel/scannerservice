package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.CompanyDao;
import com.umnikov.scannerservice.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class CompanyService {
  private final CompanyDao companyDao;

  @Autowired
  public CompanyService(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  public UserDto getUserById(Long id) {
    Company company = companyDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = company.getId();
    userDto.name = company.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Company> list = companyDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Company company = new Company();
    company.setName(request.name);
    companyDao.saveAndFlush(company);
    return request;
  }
}
