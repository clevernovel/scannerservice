package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Section;
import org.springframework.stereotype.Repository;

@Repository
public class SectionDao extends Dao<Section> {
  public SectionDao() {
    super(Section.class);
  }

  public Section saveAndFlush(Section section) {
    super.save(section);
    super.flush();
    return section;
  }
}
