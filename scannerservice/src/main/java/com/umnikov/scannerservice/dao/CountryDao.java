package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao extends Dao<Country> {
  public CountryDao() {
    super(Country.class);
  }

  public Country saveAndFlush(Country country) {
    super.save(country);
    super.flush();
    return country;
  }
}
