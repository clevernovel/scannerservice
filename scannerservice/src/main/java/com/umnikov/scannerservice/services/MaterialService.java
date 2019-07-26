package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.MaterialDto;
import com.umnikov.scannerservice.dao.MaterialDao;
import com.umnikov.scannerservice.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class MaterialService extends ServiceForController<MaterialDto, Material> {
  private final MaterialDao materialDao;

  @Autowired
  public MaterialService(MaterialDao materialDao) {
    super(materialDao);
    this.materialDao = materialDao;
  }

  public MaterialDto convertToDto(Material material) {
    MaterialDto locationDto = new MaterialDto();
    locationDto.id = material.getId();
    locationDto.name = material.getName();
    return locationDto;
  }

  public Material convertToModel(MaterialDto materialDto) {
    Material material = materialDao.findByName(materialDto.name);
    if (material == null) {
      material = new Material();
      material.setName(materialDto.name);
      materialDao.saveAndFlush(material);
    }
    return material;
  }

  @Override
  public MaterialDto edit(MaterialDto dto) {
    return null;
  }
}
