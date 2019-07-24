package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.MaterialDto;
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

  public MaterialDto getUserById(Long id) {
    Material material = materialDao.byId(id == null ? 0 : id);
    return convertToDto(material);
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Material> list = materialDao.byIds(ids);
    return list;
  }

  public MaterialDto editUser(MaterialDto request) {
    Material material = new Material();
    material.setName(request.name);
    materialDao.saveAndFlush(material);
    return request;
  }

  public MaterialDto convertToDto(Material material) {
    MaterialDto locationDto = new MaterialDto();
    locationDto.id = material.getId();
    locationDto.name = material.getName();
    return locationDto;
  }

  public Material createModel() {
    Material item = new Material();
    item.setName("test");
    Material res = materialDao.saveAndFlush(item);
    return res;
  }
}
