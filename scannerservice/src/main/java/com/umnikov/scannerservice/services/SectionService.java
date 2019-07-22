package com.umnikov.scannerservice.services;

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

  public UserDto getUserById(Long id) {
    Section section = sectionDao.byId(id == null ? 0 : id);
    UserDto userDto = new UserDto();
    userDto.id = section.getId();
    userDto.name = section.getName();
    return userDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Section> list = sectionDao.byIds(ids);
    return list;
  }

  public UserDto editUser(UserDto request) {
    Section section = new Section();
    section.setName(request.name);
    sectionDao.saveAndFlush(section);
    return request;
  }
}
