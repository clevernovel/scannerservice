package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.CompanyDto;
import com.umnikov.scannerservice.dao.CompanyDao;
import com.umnikov.scannerservice.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class CompanyService extends ServiceForController<CompanyDto, Company> {
  private final CompanyDao companyDao;

  @Autowired
  public CompanyService(CompanyDao companyDao) {
    super(companyDao);
    this.companyDao = companyDao;
  }

  public CompanyDto convertToDto(Company company) {
    CompanyDto companyDto = new CompanyDto();
    companyDto.id = company.getId();
    companyDto.name = company.getName();
    return companyDto;
  }

  @Override
  public Company convertToModel(CompanyDto dto) {
    Company company = companyDao.findByName(dto.name);
    if (company == null) {
      company = new Company();
      company.setName(dto.name);
      companyDao.saveAndFlush(company);
    }
    return company;
  }

  @Override
  public Company fillEditedFields(Company model, CompanyDto dto) {
    model.setName(dto.name);
    return companyDao.saveAndFlush(model);
  }
}
