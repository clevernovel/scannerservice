package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.QuantityDao;
import com.umnikov.scannerservice.entity.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class QuantityService {
  private final QuantityDao quantityDao;

  @Autowired
  public QuantityService(QuantityDao quantityDao) {
    this.quantityDao = quantityDao;
  }

  public UserDto getUserById(Long id) {
    Quantity quantity = quantityDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = quantity.getId();
    userDto.name = quantity.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Quantity> list = quantityDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Quantity quantity = new Quantity();
    quantity.setName(request.name);
    quantityDao.saveAndFlush(quantity);
    return request;
  }
}
