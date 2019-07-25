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
  private final LocationService locationService;
  private final QuantityService quantityService;
  private final AccountService accountService;
  private final SectionService sectionService;
  private final EquipmentService equipmentService;
  private final MaterialService materialService;

  @Autowired
  public ItemService(ItemDao itemDao, LocationService locationService, QuantityService quantityService, AccountService accountService, SectionService sectionService, EquipmentService equipmentService, MaterialService materialService) {
    this.itemDao = itemDao;
    this.locationService = locationService;
    this.quantityService = quantityService;
    this.accountService = accountService;
    this.sectionService = sectionService;
    this.equipmentService = equipmentService;
    this.materialService = materialService;
  }

  public ItemDto getItemById(Long id) {
    Item item = itemDao.byId(id == null ? 0 : id);
    return convertToDto(item);
  }

  public List getItemsByMultipleIds(List<Long> ids) {
    List<Item> list = itemDao.byIds(ids);
    return list;
  }

  private ItemDto convertToDto(Item item) {
    ItemDto itemDto = new ItemDto();
    itemDto.id = item.getId();
    itemDto.name = item.getName();
    itemDto.location = locationService.convertToDto(item.getLocation());
    itemDto.quantity = quantityService.convertToDto(item.getQuantity());
    itemDto.account = accountService.convertToDto(item.getAccount());
    itemDto.section = sectionService.convertToDto(item.getSection());
    itemDto.equipment = equipmentService.convertToDto(item.getEquipment());
    itemDto.material = materialService.convertToDto(item.getMaterial());
    itemDto.global = item.getGlobal();
    itemDto.comment = item.getComment();
    return itemDto;
  }

  //this is not edit method
  public ItemDto editItem(ItemDto request) {
    Item item = new Item();
    item.setName(request.name);
//    item.setLocation(request.location);
//    item.setQuantity(request.quantity);
//    item.setAccount(request.account);
//    item.setSection(request.section);
//    item.setEquipment(request.equipment);
//    item.setMaterial(request.material);
    item.setGlobal(request.global);
    item.setComment(request.comment);
    return request;
  }

  public Item createByRequest(ItemDto request) {
    Item item = new Item();
    item.setName(request.name);
    item.setLocation(locationService.createModelOrGetExisting(request.location));
    item.setQuantity(quantityService.createModelOrGetExisting(request.quantity));
    item.setAccount(accountService.createModel(request.account));
    item.setSection(sectionService.createModelOrGetExisting(request.section));
    item.setEquipment(equipmentService.createModelOrGetExisting(request.equipment));
    item.setMaterial(materialService.createModelOrGetExisting(request.material));
    item.setGlobal(request.global);
    item.setComment(request.comment);
    return itemDao.saveAndFlush(item);
  }

  public ItemDto create(ItemDto request) {
    return convertToDto(createByRequest(request));
  }
}
