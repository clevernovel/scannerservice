package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.QuantityDto;
import com.umnikov.scannerservice.dao.QuantityDao;
import com.umnikov.scannerservice.entity.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class QuantityService extends ServiceForController<QuantityDto, Quantity> {
  private final QuantityDao quantityDao;

  @Autowired
  public QuantityService(QuantityDao quantityDao) {
    super(quantityDao);
    this.quantityDao = quantityDao;
  }

  public QuantityDto convertToDto(Quantity quantity) {
    QuantityDto locationDto = new QuantityDto();
    locationDto.id = quantity.getId();
    locationDto.name = quantity.getName();
    return locationDto;
  }

  public Quantity convertToModel(QuantityDto quantityDto) {
    Quantity quantity = quantityDao.findByName(quantityDto.name);
    if (quantity == null) {
      quantity = new Quantity();
      quantity.setName(quantityDto.name);
      quantityDao.saveAndFlush(quantity);
    }
    return quantity;
  }

  @Override
  public Quantity fillEditedFields(Quantity model, QuantityDto dto) {
    model.setName(dto.name);
    return quantityDao.saveAndFlush(model);
  }
}
