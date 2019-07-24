package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.EquipmentDto;
import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.EquipmentDao;
import com.umnikov.scannerservice.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class EquipmentService {
  private final EquipmentDao equipmentDao;

  @Autowired
  public EquipmentService(EquipmentDao equipmentDao) {
    this.equipmentDao = equipmentDao;
  }

  public EquipmentDto getUserById(Long id) {
    Equipment equipment = equipmentDao.byId(id == null ? 0 : id);
    return convertToDto(equipment);
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Equipment> list = equipmentDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Equipment equipment = new Equipment();
    equipment.setName(request.name);
    equipmentDao.saveAndFlush(equipment);
    return request;
  }

  public EquipmentDto convertToDto(Equipment equipment) {
    EquipmentDto locationDto = new EquipmentDto();
    locationDto.id = equipment.getId();
    locationDto.name = equipment.getName();
    return locationDto;
  }

  public Equipment createModel() {
    Equipment item = new Equipment();
    item.setName("test");
    Equipment res = equipmentDao.saveAndFlush(item);
    return res;
  }
}
