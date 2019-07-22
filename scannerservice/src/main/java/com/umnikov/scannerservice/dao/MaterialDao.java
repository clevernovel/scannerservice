package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Material;
import org.springframework.stereotype.Repository;

@Repository
public class MaterialDao extends Dao<Material> {
  public MaterialDao() {
    super(Material.class);
  }

  public Material saveAndFlush(Material material) {
    super.save(material);
    super.flush();
    return material;
  }
}
