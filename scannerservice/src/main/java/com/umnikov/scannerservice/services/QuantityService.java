package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.QuantityDto;
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

  public QuantityDto getQuantityById(Long id) {
    Quantity quantity = quantityDao.byId(id == null ? 0 : id);
    return convertToDto(quantity);
  }

  public List getQuantitiesByMultipleIds(List<Long> ids) {
    List<Quantity> list = quantityDao.byIds(ids);
    return list;
  }

  public QuantityDto editUser(QuantityDto request) {
    Quantity quantity = new Quantity();
    quantity.setName(request.name);
    quantityDao.saveAndFlush(quantity);
    return request;
  }

  public QuantityDto convertToDto(Quantity quantity) {
    QuantityDto locationDto = new QuantityDto();
    locationDto.id = quantity.getId();
    locationDto.name = quantity.getName();
    return locationDto;
  }

  public Quantity createModelOrGetExisting(QuantityDto quantityDto) {
    Quantity quantity = quantityDao.findByName(quantityDto.name);
    if (quantity == null) {
      quantity = new Quantity();
      quantity.setName(quantityDto.name);
      quantityDao.saveAndFlush(quantity);
    }
    return quantity;
  }
}
