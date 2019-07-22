package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.ItemDto;
import com.umnikov.scannerservice.dao.ItemDao;
import com.umnikov.scannerservice.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager")
public class ItemService {
  private final ItemDao itemDao;

  @Autowired
  public ItemService(ItemDao itemDao) {
    this.itemDao = itemDao;
  }

  public ItemDto getUserById(Long id) {
    Item item = itemDao.byId(id == null ? 0 : id);
    ItemDto itemDto = new ItemDto();
    itemDto.id = item.getId();
    itemDto.name = item.getName();
    itemDto.location = item.getLocation();
    itemDto.quantity = item.getQuantity();
    itemDto.account = item.getAccount();
    itemDto.section = item.getSection();
    itemDto.equipment = item.getEquipment();
    itemDto.material = item.getMaterial();
    itemDto.global = item.getGlobal();
    itemDto.comment = item.getComment();
    return itemDto;
  }

  public List getUsersByMultipleIds(List<Long> ids) {
    List<Item> list = itemDao.byIds(ids);
    return list;
  }

  public ItemDto editItem(ItemDto request) {
    Item item = new Item();
    item.setName(request.name);
    item.setLocation(request.location);
    item.setQuantity(request.quantity);
    item.setAccount(request.account);
    item.setSection(request.section);
    item.setEquipment(request.equipment);
    item.setMaterial(request.material);
    item.setGlobal(request.global);
    item.setComment(request.comment);
    return request;
  }
}
