package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Quantity;
import org.springframework.stereotype.Repository;

@Repository
public class QuantityDao extends Dao<Quantity> {
  public QuantityDao() {
    super(Quantity.class);
  }

  public Quantity saveAndFlush(Quantity quantity) {
    super.save(quantity);
    super.flush();
    return quantity;
  }
}
