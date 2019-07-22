package com.umnikov.scannerlib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
  public Long id;
  public String name;
  public Long location;
  public Long quantity;
  public Long account;
  public Long section;
  public Long equipment;
  public Long material;
  public String global;
  public String comment;


  public void validation() {
    if (id < 0) {
      throw new RuntimeException();
    }
  }
}
