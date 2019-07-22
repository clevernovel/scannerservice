package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.MaterialDao;
import com.umnikov.scannerservice.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class MaterialService {
  private final MaterialDao materialDao;

  @Autowired
  public MaterialService(MaterialDao materialDao) {
    this.materialDao = materialDao;
  }

  public UserDto getUserById(Long id) {
    Material material = materialDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = material.getId();
    userDto.name = material.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Material> list = materialDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Material material = new Material();
    material.setName(request.name);
    materialDao.saveAndFlush(material);
    return request;
  }
}
