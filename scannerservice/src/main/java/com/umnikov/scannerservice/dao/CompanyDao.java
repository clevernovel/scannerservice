package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao extends Dao<Company> {
  public CompanyDao() {
    super(Company.class);
  }

  public Company saveAndFlush(Company company) {
    super.save(company);
    super.flush();
    return company;
  }
}
