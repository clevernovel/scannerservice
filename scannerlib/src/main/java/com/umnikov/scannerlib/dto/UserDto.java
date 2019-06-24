package com.umnikov.scannerlib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
  public long id;
  public String name;

  public void validation() {
    if (id < 0) {
      throw new RuntimeException();
    }
  }
}
