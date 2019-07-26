package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.EquipmentDto;
import com.umnikov.scannerservice.dao.EquipmentDao;
import com.umnikov.scannerservice.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class EquipmentService extends ServiceForController<EquipmentDto, Equipment> {
  private final EquipmentDao equipmentDao;

  @Autowired
  public EquipmentService(EquipmentDao equipmentDao) {
    super(equipmentDao);
    this.equipmentDao = equipmentDao;
  }

  @Override
  public EquipmentDto convertToDto(Equipment equipment) {
    EquipmentDto locationDto = new EquipmentDto();
    locationDto.id = equipment.getId();
    locationDto.name = equipment.getName();
    return locationDto;
  }

  @Override
  public Equipment convertToModel(EquipmentDto dto) {
    Equipment equipment = equipmentDao.findByName(dto.name);
    if (equipment == null) {
      equipment = new Equipment();
      equipment.setName(dto.name);
      equipmentDao.saveAndFlush(equipment);
    }
    return equipment;
  }

  @Override
  public EquipmentDto edit(EquipmentDto dto) {
    return null;
  }
}
