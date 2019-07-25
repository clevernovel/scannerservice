package com.umnikov.scannerlib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
  public Long id;
  public String name;
  public LocationDto location;
  public QuantityDto quantity;
  public AccountDto account;
  public SectionDto section;
  public EquipmentDto equipment;
  public MaterialDto material;
  public String global;
  public String comment;

  //only for edit
  public void validation() {
    if (id < 0) {
      throw new RuntimeException();
    }
  }
}
