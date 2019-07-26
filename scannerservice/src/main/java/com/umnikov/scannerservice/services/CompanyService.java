package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.CompanyDto;
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

  public CompanyDto getCompanyById(Long id) {
    Company company = companyDao.byId(id == null ? 0 : id);
    return convertToDto(company);
  }

  public List getCompaniesByMultipleIds(List<Long> ids) {
    return companyDao.byIds(ids);
  }

  public CompanyDto editUser(CompanyDto request) {
    Company company = new Company();
    company.setName(request.name);
    companyDao.saveAndFlush(company);
    return request;
  }

  public Company createModelOrGetExisting(CompanyDto companyDto) {
    Company company = companyDao.findByName(companyDto.name);
    if (company == null) {
      company = new Company();
      company.setName(companyDto.name);
      companyDao.saveAndFlush(company);
    }
    return company;
  }

  public CompanyDto convertToDto(Company company) {
    CompanyDto companyDto = new CompanyDto();
    companyDto.id = company.getId();
    companyDto.name = company.getName();
    return companyDto;
  }

  public CompanyDto create(CompanyDto request) {
    return convertToDto(createModelOrGetExisting(request));
  }
}
