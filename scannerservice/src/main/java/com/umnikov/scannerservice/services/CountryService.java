package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.CountryDto;
import com.umnikov.scannerservice.dao.CountryDao;
import com.umnikov.scannerservice.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class CountryService extends ServiceForController<CountryDto, Country> {
  private final CountryDao countryDao;

  @Autowired
  public CountryService(CountryDao countryDao) {
    super(countryDao);
    this.countryDao = countryDao;
  }

  @Override
  public CountryDto convertToDto(Country country) {
    CountryDto countryDto = new CountryDto();
    countryDto.id = country.getId();
    countryDto.name = country.getName();
    return countryDto;
  }

  @Override
  public Country convertToModel(CountryDto dto) {
    Country country = countryDao.findByName(dto.name);
    if (country == null) {
      country = new Country();
      country.setName(dto.name);
      countryDao.saveAndFlush(country);
    }
    return country;
  }

  @Override
  public CountryDto edit(CountryDto dto) {
    return null;
  }
}
