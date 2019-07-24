package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.CountryDto;
import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.CountryDao;
import com.umnikov.scannerservice.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class CountryService {
  private final CountryDao countryDao;

  @Autowired
  public CountryService(CountryDao countryDao) {
    this.countryDao = countryDao;
  }

  public CountryDto getUserById(Long id) {
    Country country = countryDao.byId(id == null ? 0 : id);
    return convertToDto(country);
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    return countryDao.byIds(ids);
  }

  public UserDto editUser(UserDto request) {
    Country country = new Country();
    country.setName(request.name);
    countryDao.saveAndFlush(country);
    return request;
  }

  public Country createModel() {
    Country country = new Country();
    country.setName("test");
    return countryDao.saveAndFlush(country);
  }

  public CountryDto convertToDto(Country country) {
    CountryDto countryDto = new CountryDto();
    countryDto.id = country.getId();
    countryDto.name = country.getName();
    return countryDto;
  }
}
