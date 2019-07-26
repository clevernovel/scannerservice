package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.SectionDto;
import com.umnikov.scannerservice.dao.SectionDao;
import com.umnikov.scannerservice.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class SectionService extends ServiceForController<SectionDto, Section> {
  private final SectionDao sectionDao;

  @Autowired
  public SectionService(SectionDao sectionDao) {
    super(sectionDao);
    this.sectionDao = sectionDao;
  }

  public SectionDto convertToDto(Section section) {
    SectionDto sectionDto = new SectionDto();
    sectionDto.id = section.getId();
    sectionDto.name = section.getName();
    return sectionDto;
  }

  public Section convertToModel(SectionDto sectionDto) {
    Section section = sectionDao.findByName(sectionDto.name);
    if (section == null) {
      section = new Section();
      section.setName(sectionDto.name);
      sectionDao.saveAndFlush(section);
    }
    return section;
  }

  @Override
  public SectionDto edit(SectionDto dto) {
    return null;
  }
}

