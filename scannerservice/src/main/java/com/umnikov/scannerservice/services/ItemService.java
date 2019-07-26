package com.umnikov.scannerservice.services;

import com.umnikov.scannerlib.dto.ItemDto;
import com.umnikov.scannerservice.dao.ItemDao;
import com.umnikov.scannerservice.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class ItemService extends ServiceForController<ItemDto, Item> {
  private final ItemDao itemDao;
  private final LocationService locationService;
  private final QuantityService quantityService;
  private final AccountService accountService;
  private final SectionService sectionService;
  private final EquipmentService equipmentService;
  private final MaterialService materialService;

  @Autowired
  public ItemService(ItemDao itemDao, LocationService locationService, QuantityService quantityService, AccountService accountService, SectionService sectionService, EquipmentService equipmentService, MaterialService materialService) {
    super(itemDao);
    this.itemDao = itemDao;
    this.locationService = locationService;
    this.quantityService = quantityService;
    this.accountService = accountService;
    this.sectionService = sectionService;
    this.equipmentService = equipmentService;
    this.materialService = materialService;
  }

  @Override
  public ItemDto convertToDto(Item item) {
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

  @Override
  public Item convertToModel(ItemDto dto) {
    Item item = new Item();
    item.setName(dto.name);
    item.setLocation(locationService.convertToModel(dto.location));
    item.setQuantity(quantityService.convertToModel(dto.quantity));
    item.setAccount(accountService.convertToModel(dto.account));
    item.setSection(sectionService.convertToModel(dto.section));
    item.setEquipment(equipmentService.convertToModel(dto.equipment));
    item.setMaterial(materialService.convertToModel(dto.material));
    item.setGlobal(dto.global);
    item.setComment(dto.comment);
    return item;
  }

  @Override
  public ItemDto edit(ItemDto dto) {
    return null;
  }
}
