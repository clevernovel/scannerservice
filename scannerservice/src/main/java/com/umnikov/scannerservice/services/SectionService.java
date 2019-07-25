package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.SectionDto;
import com.umnikov.scannerlib.dto.UserDto;
import com.umnikov.scannerservice.dao.SectionDao;
import com.umnikov.scannerservice.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class SectionService {
  private final SectionDao sectionDao;

  @Autowired
  public SectionService(SectionDao sectionDao) {
    this.sectionDao = sectionDao;
  }

  public SectionDto getSectionById(Long id) {
    Section section = sectionDao.byId(id == null ? 0 : id);
    return convertToDto(section);
  }

  public List getSectionsByMultipleIds(List<Long> ids) {
    return sectionDao.byIds(ids);
  }

  public SectionDto editUser(SectionDto request) {
    Section section = new Section();
    section.setName(request.name);
    sectionDao.saveAndFlush(section);
    return request;
  }

  public SectionDto convertToDto(Section section) {
    SectionDto sectionDto = new SectionDto();
    sectionDto.id = section.getId();
    sectionDto.name = section.getName();
    return sectionDto;
  }

  public Section createModelOrGetExisting(SectionDto sectionDto) {
    Section section = sectionDao.findByName(sectionDto.name);
    if (section == null) {
      section = new Section();
      section.setName(sectionDto.name);
      sectionDao.saveAndFlush(section);
    }
    return section;
  }
}

