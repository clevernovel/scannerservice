package com.umnikov.scannerservice.services;

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

  public UserDto getUserById(Long id) {
    Country country = countryDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = country.getId();
    userDto.name = country.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Country> list = countryDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Country country = new Country();
    country.setName(request.name);
    countryDao.saveAndFlush(country);
    return request;
  }
}
