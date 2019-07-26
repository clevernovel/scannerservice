package com.umnikov.scannerlib.dto;

public abstract class BaseIdNameDto implements GetId {
  public long id;
  public String name;

  public void validation() {
    if (id < 0) {
      throw new RuntimeException();
    }
  }

  @Override
  public Long getId() {
    return id;
  }
}
