package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Equipment;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentDao extends Dao<Equipment> {
  public EquipmentDao() {
    super(Equipment.class);
  }

  public Equipment saveAndFlush(Equipment equipment) {
    super.save(equipment);
    super.flush();
    return equipment;
  }
}
